package com.psousa.javajdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SetupDatabase {


    public static void main(String[] args) {

        Connection connection = new ConnectionFactory().getConnection();

        createTableMovies(connection);
//        dropTableMovies(connection);
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
