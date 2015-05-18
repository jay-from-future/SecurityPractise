package com.grishalyullin.persistence;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    private static final Logger LOG = Logger.getLogger(JdbcConnection.class.getName());

    private static final String URL = "jdbc:sqlite:sql_injection_practise.db";

    private Connection connection;

    public JdbcConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(URL);
            if (!connection.isClosed()) {
                LOG.info("JDBC connection has been successfully created");
            }
        } catch (ClassNotFoundException e) {
            LOG.warn("Could not create connection", e);
        } catch (SQLException e) {
            LOG.warn("Could not create connection", e);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
