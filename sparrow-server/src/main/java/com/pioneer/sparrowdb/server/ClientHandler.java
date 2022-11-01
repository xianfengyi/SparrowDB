package com.pioneer.sparrowdb.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler extends Thread {

    /**
     * The unique ID assigned to this client.
     */
    private int id;

    /**
     * The socket this client-handler uses to interact with its client.
     */
    private Socket socket;

    /**
     * An input-stream for de-serializing objects sent from the client.
     */
    private ObjectInputStream objectInput;

    /**
     * An output-stream for serializing objects to send to the client.
     */
    private ObjectOutputStream objectOutput;

    public ClientHandler(int id, Socket socket) {
        this.id = id;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            objectInput = new ObjectInputStream(socket.getInputStream());

            objectOutput = new ObjectOutputStream(socket.getOutputStream());
            while (true) {
                String command = (String) objectInput.readObject();
                System.out.println(command);
                objectOutput.writeObject("received");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
