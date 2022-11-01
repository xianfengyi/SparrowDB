package com.pioneer.sparrowdb.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class SparrowClient {
    /**
     * The socket used to communicate with the shared server.
     */
    private Socket socket;

    /**
     * This stream is used to receive objects (tuples, messages, etc.) from
     * the server.
     */
    private ObjectInputStream objectInput;


    /**
     * This stream is used to send objects (commands, specifically) to the
     * server.
     */
    private ObjectOutputStream objectOutput;


    /**
     * This object receives data from the server asynchronously,
     * and prints out whatever it receives.  It is wrapped by the
     * {@link #receiverThread}.
     */
    private Receiver receiver;


    /**
     * This is the thread that the {@link #receiver} object runs within.
     */
    private Thread receiverThread;


    public SparrowClient(String hostname, int port) throws IOException {
        // Try to establish a connection to the shared database server.
        socket = new Socket(hostname, port);
        objectOutput = new ObjectOutputStream(socket.getOutputStream());
        objectInput = new ObjectInputStream(socket.getInputStream());
    }

    public void startup() {
        // Start up the receiver thread that will print out whatever comes
        // across the wire.
        receiver = new Receiver(System.out);
        receiverThread = new Thread(receiver);
        receiverThread.start();
    }

    public void handleCommand(String command) {
        try {
            objectOutput.writeObject(command);
        }
        catch (IOException e) {
            throw new RuntimeException("Unexpected error while transmitting command", e);
        }
    }

    /**
     * This helper class prints out the results that come back from the
     * server.  It is intended to run within a separate thread.
     */
    private class Receiver implements Runnable {
        /**
         * The print-stream to output server results on.
         */
        private PrintStream out;


        /**
         * A flag indicating when the receiver thread should shut down.
         */
        private boolean done;


        public Receiver(PrintStream out) {
            this.out = out;
        }


        public void run() {
            done = false;
            while (true) {
                try {
                    Object obj = objectInput.readObject();
                    System.out.println(obj);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public void shutdown() {
            // TODO:  Probably need to interrupt the thread.  This is pretty
            //        insufficient, particularly for long-running queries.
            done = true;
        }
    }


}
