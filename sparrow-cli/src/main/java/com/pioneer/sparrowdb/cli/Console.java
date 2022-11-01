package com.pioneer.sparrowdb.cli;

import com.pioneer.sparrowdb.client.SparrowClient;
import jline.console.history.FileHistory;
import jline.console.history.History;
import jline.console.history.MemoryHistory;

import java.io.File;
import java.io.IOException;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.io.Files.createParentDirs;
import static java.util.Locale.ENGLISH;
import static jline.internal.Configuration.getUserHome;

public class Console {

    private static final String PROMPT_NAME = "sparrow";

    private static SparrowClient client = new SparrowClient();

    public boolean run() {
        runConsole();
        return true;
    }

    private static void runConsole() {
        try (LineReader reader = new LineReader(getHistory())) {
            String commandPrompt = PROMPT_NAME + "> ";
            StringBuilder buffer = new StringBuilder();
            while (true) {
                String line = reader.readLine(commandPrompt);

                // add buffer to history and clear on user interrupt
                if (reader.interrupted()) {
                    buffer = new StringBuilder();
                    continue;
                }

                // exit on EOF
                if (line == null) {
                    System.out.println();
                    return;
                }
                if (buffer.length() == 0) {
                    String command = line.trim();
                    if (command.endsWith(";")) {
                        command = command.substring(0, command.length() - 1).trim();
                    }
                    switch (command.toLowerCase(ENGLISH)) {
                        case "exit":
                        case "quit":
                            return;
                        case "history":
                            for (History.Entry entry : reader.getHistory()) {
                                System.out.printf("%5d  %s%n", entry.index() + 1, entry.value());
                            }
                            continue;
                        case "help":
                            System.out.println("help");
                            continue;
                    }
                }

                // not a command, add line to buffer
                buffer.append(line).append("\n");
                // execute any complete statements
                String sql = buffer.toString();
                client.handleCommand(sql);

                // replace buffer with trailing partial statement
                buffer = new StringBuilder();
            }
        } catch (IOException exp) {
            System.err.println("Readline error: " + exp.getMessage());
        }
    }

    private static History getHistory() {
        String historyFilePath = System.getenv("PRESTO_HISTORY_FILE");
        File historyFile;
        if (isNullOrEmpty(historyFilePath)) {
            historyFile = new File(getUserHome(), ".presto_history");
        } else {
            historyFile = new File(historyFilePath);
        }
        return getHistory(historyFile);
    }

    private static MemoryHistory getHistory(File historyFile) {
        MemoryHistory history;
        try {
            //  try creating the history file and its parents to check
            // whether the directory tree is readable/writeable
            createParentDirs(historyFile.getParentFile());
            historyFile.createNewFile();
            history = new FileHistory(historyFile);
            history.setMaxSize(10000);
        } catch (IOException e) {
            System.err.printf("WARNING: Failed to load history file (%s): %s. " + "History will not be available " +
                    "during this session.%n", historyFile, e.getMessage());
            history = new MemoryHistory();
        }
        history.setAutoTrim(true);
        return history;
    }
}
