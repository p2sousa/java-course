package com.psousa.javajdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        MovieDAO daoMovie = new MovieDAO();

        System.out.println("--------Menu------------");
        System.out.println("1 - List movies");
        System.out.println("2 - Create a movie");
        System.out.println("3 - Update a movie");
        System.out.println("4 - Delete a movie");
        System.out.println("--------Menu------------");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                ArrayList<Movie> data = (ArrayList<Movie>) daoMovie.findAll();
                for (Movie movie : data) {
                    System.out.println("Id: " + movie.getId());
                    System.out.println("Name: " + movie.getName());
                }
                break;
            case 2:
                System.out.println("Enter name: ");
                String name = scanner.next();
                daoMovie.insert(new Movie(name));

                break;
            case 3:
                System.out.println("Enter Movie ID: ");
                Integer id = scanner.nextInt();

                Movie movieExist = daoMovie.findById(id);

                if (movieExist == null) {
                    System.out.println("Movie not exist");
                    break;
                }

                System.out.println("Enter new Movie name: ");
                String movieName = scanner.next();
                Movie newMovie = new Movie(movieExist.getId(), movieName);
                daoMovie.update(movieExist, newMovie);
                break;
            case 4:
                System.out.println("Enter Movie ID: ");
                Integer movieId = scanner.nextInt();

                Movie movieToDelete = daoMovie.findById(movieId);

                if (movieToDelete == null) {
                    System.out.println("Movie not exist");
                    break;
                }

                daoMovie.delete(movieToDelete);
                break;
            default:
                System.out.println("Invalid Option!");
        }

    }

}
