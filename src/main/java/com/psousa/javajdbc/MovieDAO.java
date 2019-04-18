package com.psousa.javajdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {

    private Connection connection;
    private PreparedStatement statement;

    public MovieDAO() {
        connection = new ConnectionFactory().getConnection();
    }

    public List<Movie> findAll() throws SQLException {
        String query = "SELECT * FROM movies";
        List<Movie> movies = new ArrayList<Movie>();

        statement = connection.prepareStatement(query);

        ResultSet response = statement.executeQuery();

        while (response.next()) {
            movies.add(
                new Movie(
                    response.getInt("id"),
                    response.getString("name")
                )
            );
        }

        return movies;
    }

    public void insert(Movie movie) {

    }

    public void update(Movie movie, Movie movieData) {

    }

    public void delete(Movie movie) {

    }
}
