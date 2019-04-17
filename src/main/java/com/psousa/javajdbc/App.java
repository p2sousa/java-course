package com.psousa.javajdbc;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--------Menu------------");
        System.out.println("1 - List movies");
        System.out.println("2 - Create a movie");
        System.out.println("3 - Update a movie");
        System.out.println("4 - Delete a movie");
        System.out.println("--------Menu------------");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("CASE 1");
                break;
            case 2:
                System.out.println("CASE 2");
                break;
            case 3:
                System.out.println("CASE 3");
                break;
            case 4:
                System.out.println("CASE 4");
                break;
            default:
                System.out.println("Invalid Option!");
        }

    }

}
