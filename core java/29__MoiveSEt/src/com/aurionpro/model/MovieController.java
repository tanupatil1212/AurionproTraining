package com.aurionpro.model;

import java.util.List;
import java.util.Scanner;

public class MovieController {
	private MovieManger manager;

    public MovieController() {
        manager = new MovieManger();
       
        
    }

    public void start() {
        displayMenu();
    }

    private void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Movie Store Menu");
            System.out.println("1. Add Movie");
            System.out.println("2. Clear Movies");
            System.out.println("3. List Movies");
            System.out.println("4. Find movie by its ID");
            System.out.println("5. Delete movie by its ID");
            System.out.println("6. Exit");
        
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    Movie movie = setMovieDetails();
                    manager.addMovie(movie);
                    break;
                case 2:
                    manager.clearMovies();
                    System.out.println("All movies cleared.");
                    break;
                case 3:
                    List<Movie> movies = manager.getMovies();
                    if (movies.isEmpty()) {
                        System.out.println("No movies available.");
                    } else {
                        System.out.println("Movies:");
                        for (Movie m : movies) {
                            System.out.println(m.id + ". " + m.name + " (" + m.year + ") - " + m.genre);
                        }
                    }
                    break;
                
                
                case 4:
                    System.out.print("Enter the movie ID to find: ");
                    int findId = scanner.nextInt();
                    Movie foundMovie = manager.findMovieById(findId);
                    if (foundMovie != null) {
                        System.out.println("Found movie: " + foundMovie);
                    } else {
                        System.out.println("Movie with ID " + findId + " not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter the movie ID to delete: ");
                    int deleteId = scanner.nextInt();
                    manager.deleteMovieById(deleteId);
                    System.out.println("Movie with ID " + deleteId + " deleted.");
                    break;
                    
                case 6:
                    System.out.println("Exiting...");
                    break;     
    
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 6);
    }

    private Movie setMovieDetails() {
        Scanner scanner = new Scanner(System.in);
        int id = manager.getMovieId();
        System.out.print("Enter movie name: ");
        String name = scanner.nextLine();
        System.out.print("Enter movie year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter movie genre: ");
        String genre = scanner.nextLine();

        return new Movie(id, name, year, genre);
    }
}


