package com.pioneer.sparrowdb.client;

import java.io.IOException;

public class Main {

    public static void main(String args[]) throws IOException {
        String host = "127.0.0.1";
        int port = 9093;
        SparrowClient client = new SparrowClient(host, port);

        String sql = "select * from test";
        client.handleCommand(sql);

        client.startup();
    }
}
