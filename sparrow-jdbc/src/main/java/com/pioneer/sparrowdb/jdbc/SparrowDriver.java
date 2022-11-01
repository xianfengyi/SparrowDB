package com.pioneer.sparrowdb.jdbc;

import okhttp3.OkHttpClient;

import java.io.Closeable;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class SparrowDriver implements Driver, Closeable {

    private static final String DRIVER_URL_START = "jdbc:sparrow:";

    private final OkHttpClient httpClient = new OkHttpClient.Builder().build();

    static {
        try {
            DriverManager.registerDriver(new SparrowDriver());
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws IOException {
        httpClient.dispatcher().executorService().shutdown();
        httpClient.connectionPool().evictAll();
    }

    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        if (!acceptsURL(url)) {
            return null;
        }

        return new SparrowConnection();
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return url.startsWith(DRIVER_URL_START);
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        return new DriverPropertyInfo[0];
    }

    @Override
    public int getMajorVersion() {
        return 0;
    }

    @Override
    public int getMinorVersion() {
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
