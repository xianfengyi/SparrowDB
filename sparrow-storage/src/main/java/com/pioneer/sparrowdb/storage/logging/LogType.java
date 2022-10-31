package com.pioneer.sparrowdb.storage.logging;

public interface LogType {

    int TX_START = 0;
    int PAGE_FLUSH = 1;
    int TX_COMMIT = 2;
}
