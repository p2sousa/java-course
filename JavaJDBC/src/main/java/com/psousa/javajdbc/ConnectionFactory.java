package com.psousa.javajdbc;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private String url;
    private String user;
    private String password;
    private final String CLASS_DRIVER = "com.mysql.cj.jdbc.Driver";

    public ConnectionFactory() {

        Dotenv dotenv = Dotenv.configure()
            .directory(System.getProperty("user.dir"))
            .ignoreIfMalformed()
            .ignoreIfMissing()
            .load();

        String urlConnector = "jdbc:mysql://";

        urlConnector += dotenv.get("DB_HOST");
        urlConnector += ":" + dotenv.get("DB_PORT");
        urlConnector += "/" + dotenv.get("DB_DATABASE");
        urlConnector += "?useSSL=false";

        url = urlConnector;
        user = dotenv.get("DB_USER");
        password = dotenv.get("DB_PASSWORD");
    }

    private Connection createConnection() throws ClassNotFoundException {

        Connection connection = null;

        try {
            Class.forName(CLASS_DRIVER);
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public Connection getConnection() {
        try {
            return createConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}
