package com.pioneer.sparrowdb.cli;

import jline.console.history.History;

import java.io.IOException;

public class Console {

    private static final String PROMPT_NAME = "sparrow";

    private static void runConsole() {
        try (LineReader reader = new LineReader(getHistory())) {
            String commandPrompt = PROMPT_NAME + "> ";
            String line = reader.readLine(commandPrompt);
            // exit on EOF
            if (line == null) {
                System.out.println();
                return;
            }
        } catch (IOException exp) {

        }
    }

    private static History getHistory() {
        return null;
    }
}
