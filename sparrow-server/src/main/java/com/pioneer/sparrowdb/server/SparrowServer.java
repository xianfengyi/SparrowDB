package com.pioneer.sparrowdb.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SparrowServer extends Thread {

    private static final int BOSS_THREAD_COUNT = 1;

    private static final int SERVER_PORT = 9093;

    public void startup() throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);

        int clientID = 0;
        while (true) {
            Socket sock = serverSocket.accept();
            clientID++;
            ClientHandler clientHandler = new ClientHandler(clientID, sock);
            clientHandler.start();
        }
    }

}
