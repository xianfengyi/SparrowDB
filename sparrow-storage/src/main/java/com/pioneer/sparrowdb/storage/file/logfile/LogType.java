package com.pioneer.sparrowdb.storage.file.logfile;

public interface LogType {

    int TX_START = 0;
    int PAGE_FLUSH = 1;
    int TX_COMMIT = 2;
}
