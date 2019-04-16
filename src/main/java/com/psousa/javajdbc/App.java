package com.psousa.javajdbc;

import io.github.cdimascio.dotenv.Dotenv;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Dotenv dotenv = Dotenv.configure()
            .directory(System.getProperty("user.dir"))
            .ignoreIfMalformed()
            .ignoreIfMissing()
            .load();
    }

}
