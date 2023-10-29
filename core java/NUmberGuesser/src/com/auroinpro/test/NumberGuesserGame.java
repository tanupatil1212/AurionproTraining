package com.auroinpro.test;

import java.util.Scanner;
import java.util.Random;

public class NumberGuesserGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        System.out.println("Welcome to Number Guesser Game!");

        while (playAgain) {
            int secretNumber = random.nextInt(100) + 1;
            int maxAttempts = 5; // Set the maximum number of attempts to 5
            int tries = 0;
            int guess;

            while (tries < maxAttempts) {
                System.out.print("Guess a number between 1 and 100: ");

                try {
                    guess = scanner.nextInt();
                    tries++;

                    if (guess < secretNumber) {
                        System.out.println("Sorry, Too Low.");
                    } else if (guess > secretNumber) {
                        System.out.println("Sorry, Too High.");
                    } else {
                        System.out.println("Congratulations! You guessed the correct number " + secretNumber + " in " + tries + " tries.");
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next();
                }
            }

            if (tries == maxAttempts) {
                System.out.println("Sorry, you have used all " + maxAttempts + " attempts. The correct number was " + secretNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();

            if (!playAgainResponse.startsWith("y")) {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing Number Guesser Game!");
    }

}
