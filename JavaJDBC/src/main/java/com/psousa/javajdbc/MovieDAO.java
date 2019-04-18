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


    public Movie findById(Integer id) throws SQLException {
        String query = "SELECT * FROM movies WHERE id = ?";

        statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        ResultSet response = statement.executeQuery();

        Movie movie = null;

        while (response.next()) {
            movie = new Movie(
                response.getInt("id"),
                response.getString("name")
            );
        }

        return movie;
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

    public void insert(Movie movie) throws SQLException {
        String query = "INSERT INTO movies (name) VALUES (?)";

        statement = connection.prepareStatement(query);
        statement.setString(1, movie.getName());
        statement.execute();
    }

    public void update(Movie movie, Movie movieData) throws SQLException {
        String query = "UPDATE movies SET name = ? WHERE id = ?";

        statement = connection.prepareStatement(query);
        statement.setString(1, movieData.getName());
        statement.setInt(2, movie.getId());
        statement.execute();
    }

    public void delete(Movie movie) throws SQLException {
        String query = "DELETE FROM movies WHERE id = ?";

        statement = connection.prepareStatement(query);
        statement.setInt(1, movie.getId());
        statement.execute();
    }
}
