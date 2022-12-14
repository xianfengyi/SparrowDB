package com.pioneer.sparrowdb.server;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        System.out.println("start server");
        SparrowServer server = new SparrowServer();
        try {
            server.startup();
        } catch (IOException e) {
            System.out.println("Couldn't start shared server:  " + e.getMessage());
        }
    }
}
