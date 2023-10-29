package com.aurionpro.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieManager {
	

	
		private static final String filepath = "D:\\\\Aurionpro\\\\core java\\\\29__MoiveSEt\\\\Movie.txt";
		  private List<Movie> movies;

		  public MovieManager() {
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
		    int id = 1;
		    for (Movie movie : movies) {
		      if (movie.getId() > id) {
		        id = movie.getId() + 1;
		      }
		    }
		    return id;
		  }

		  public void loadMovies() {
		    try {
		      FileInputStream fileInputStream = new FileInputStream(filepath);
		      ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		      movies = (List<Movie>) objectInputStream.readObject();
		      objectInputStream.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("File not found: " + filepath);
		    } catch (IOException e) {
		      System.out.println("Error reading file: " + filepath);
		    } catch (ClassNotFoundException e) {
		      System.out.println("Class not found: " + filepath);
		    }
		  }

		  public void saveMovies() {
		    try {
		      FileOutputStream fileOutputStream = new FileOutputStream(filepath);
		      ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		      objectOutputStream.writeObject(movies);
		      objectOutputStream.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("File not found: " + filepath);
		    } catch (IOException e) {
		      System.out.println("Error writing file: " + filepath);
		    }
		  }
		  
		  public void deleteMovie(int ID) {
				for (Movie movie : movies) {
					if (movie.getId() == ID) {
						movies.remove(movie);
						break;
					}
				}
//				System.out.println(movies);
			}

		  public void deleteAllMovies() {
		    movies.clear();
		    saveMovies();
		  }
		}