package com.aurionpro.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieManger {
	List<Movie> movies = new ArrayList<>();
		    


	static final String filePath = "D:\\Aurionpro\\core java\\29__MoiveSEt\\Movie.txt";
	
	 public MovieManger() {
	        movies = new ArrayList<>();
	        loadMovies();
	    }

	    public void addMovie(Movie movie) {
	        movies.add(movie);
	        saveMovies();
	    }

	    public void clearMovies() {
	        movies.clear();
	        saveMovies();
	    }

	    public List<Movie> getMovies() {
	        return movies;
	    }

	    public int getMovieId() {
	        if (movies.isEmpty()) {
	            return 1;
	        }
	        return movies.get(movies.size() - 1).id + 1;
	    }
	    
	    public Movie findMovieById(int id) {
	        for (Movie movie : movies) {
	            if (movie.getId() == id) {
	                return movie;
	            }
	        }
	        return null; // Movie with the given ID not found
	    }

	    public void deleteMovieById(int id) {
	        movies.removeIf(movie -> movie.getId() == id);
	        saveMovies();
	    }


	    public void loadMovies() {
	        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
	            List<Movie> loadedMovies = (List<Movie>) inputStream.readObject();
	            movies.addAll(loadedMovies); // Add loaded movies to the existing list
	        } catch (IOException | ClassNotFoundException e) {
	            // Print the full exception stack trace for debugging purposes
	            e.printStackTrace();
	            System.err.println("Error loading movies: " + e.getMessage());
	        }
	    }

	    

	    public void saveMovies() {
	        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
	            outputStream.writeObject(movies);
	        } catch (IOException e) {
	            System.err.println("Error saving movies: " + e.getMessage());
	        }
	    }

	    public void deleteAllMovies() {
	        movies.clear();
	        saveMovies();
	    }
	}

//load deserialized //save serialized
