package com.aurionpro.model;

import java.util.List;
import java.util.Scanner;

public class MovieController {
	


	
		private MovieManager manager;

		  public MovieController() {
		    manager = new MovieManager();
		  }

		  public void start() {
		    displayMenu();
		  }

		  public void displayMenu() {
			  Scanner scanner = new Scanner(System.in); 
		        int choice; 
		        do { 
		            System.out.println("Welcome to the Movie Store!!!!!"); 
		            System.out.println("1. Add Movie"); 
		            System.out.println("2. Clear All Movies"); 
		            System.out.println("3. Delete Movie");
		            System.out.println("4. List Movies"); 
		            System.out.println("5. Exit"); 
		            System.out.print("Enter your choice here: "); 
		            choice = scanner.nextInt(); 
		            scanner.nextLine(); // Consume the newline character 
		 
		            int id;
					switch (choice) { 
		                case 1: 
		                    Movie movie = setMovieDetails(); 
		                    manager.addMovie(movie); 
		                    System.out.println("Movie added Successfully");
		                    break; 
		                case 2: 
		                    manager.clearMovies(); 
		                    System.out.println("All movies cleared."); 
		                    break; 
		            	case 3:
		        			System.out.print("Enter Id: ");
		        			id = scanner.nextInt();
		        			manager.deleteMovie(id);
		        			manager.saveMovies();
		        			break;
		                case 4: 
		                    List<Movie> movies = manager.getMovies(); 
		                    if (movies.isEmpty()) { 
		                        System.out.println("No movies available."); 
		                    } else { 
		                        System.out.println("Movies:"); 
		                        for (Movie m : movies) { 
		                            System.out.println("List of Movies : " +m.getId() + ". " + m.getName() + " (" + m.getYear() + ") - " + m.getGenre()); 
		                        } 
		                    } 
		                    break; 
		                case 5: 
		                    System.out.println("Exiting..."); 
		                    break; 
		                default: 
		                    System.out.println("Invalid choice. Please select a valid option."); 
		            } 
		        } while (choice != 5); 
		    } 

		private Movie setMovieDetails() {
			Scanner scanner = new Scanner(System.in); 
	        int id = manager.getMovieId(); 
	       
	        System.out.print("Enter movie name: "); 
	        String name = scanner.nextLine(); 
	       
	        System.out.print("Enter movie year: "); 
	        int year = scanner.nextInt(); 
	        scanner.nextLine();
	      
	        System.out.print("Enter movie genre: "); 
	        String genre = scanner.nextLine(); 
	 
	        //String genre = scanner.nextLine();
			return new Movie(id, name, year,genre);
		}

		}


