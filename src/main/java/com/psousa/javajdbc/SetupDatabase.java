package com.psousa.javajdbc;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SetupDatabase {

    public static void main(String[] args) {

        Connection connection = connectDatabase();

        createTableMovies(connection);
//        dropTableMovies(connection);
    }

    private static Connection connectDatabase() {
        Dotenv dotenv = Dotenv.configure()
                .directory(System.getProperty("user.dir"))
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Loaded");
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to Load");
            e.printStackTrace();
        }

        Connection connection = null;

        String urlConnector = "jdbc:mysql://";

        urlConnector += dotenv.get("DB_HOST");
        urlConnector += ":" + dotenv.get("DB_PORT");
        urlConnector += "/" + dotenv.get("DB_DATABASE");
        urlConnector += "?useSSL=false";

        try {
            connection = DriverManager.getConnection(
                    urlConnector,
                    dotenv.get("DB_USER"),
                    dotenv.get("DB_PASSWORD")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    private static Boolean createTableMovies(Connection connection) {
        Statement statement = null;

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "CREATE TABLE IF NOT EXISTS movies (id INTEGER NOT NULL AUTO_INCREMENT, " +
                "name VARCHAR(255) NOT NULL, PRIMARY KEY (id))";

        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    private static Boolean dropTableMovies(Connection connection) {
        Statement statement = null;

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "DROP TABLE movies";

        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }
}
