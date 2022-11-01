package com.pioneer.sparrowdb.cli;

public class Sparrow {

    public static void main(String[] args) {
        Console console = new Console();
        System.exit(console.run() ? 0 : 1);
    }
}
