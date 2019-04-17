package com.psousa.javajdbc;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) {
        
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

        if (connection != null) {
            System.out.println("Connected");
        } else {
            System.out.println("Connected Failed");
        }
    }

}
