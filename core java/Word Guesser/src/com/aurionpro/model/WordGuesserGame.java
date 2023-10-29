package com.aurionpro.model;

import java.util.Scanner;

public class WordGuesserGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        System.out.println("Welcome to Word Guesser Game!");

        while (playAgain) {
            String secretWord = getRandomWord();
            int maxAttempts = 5; // Set the maximum number of attempts to 5
            int attempts = 0;
            boolean wordGuessed = false;

            char[] guessedLetters = new char[secretWord.length()];
            for (int i = 0; i < guessedLetters.length; i++) {
                guessedLetters[i] = '_';
            }

            while (attempts < maxAttempts) {
                System.out.println("Current word: " + String.valueOf(guessedLetters));
                System.out.print("Guess a letter: ");
                char guess = scanner.next().charAt(0);

                if (secretWord.indexOf(guess) != -1) {
                    for (int i = 0; i < secretWord.length(); i++) {
                        if (secretWord.charAt(i) == guess) {
                            guessedLetters[i] = guess;
                        }
                    }
                    if (String.valueOf(guessedLetters).equals(secretWord)) {
                        wordGuessed = true;
                        break;
                    }
                } else {
                    attempts++;
                    System.out.println("Incorrect guess! Attempts left: " + (maxAttempts - attempts));
                }
            }

            if (wordGuessed) {
                System.out.println("Congratulations! You guessed the word: " + secretWord);
            } else {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The word was: " + secretWord);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();

            if (!playAgainResponse.startsWith("y")) {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing Word Guesser Game!");
        scanner.close();
    }

    private static String getRandomWord() {
        String[] words = {"apple", "banana", "orange", "grape", "pineapple", "strawberry", "watermelon", "kiwi"};
        int randomIndex = (int) (Math.random() * words.length);
        return words[randomIndex];
    }
}
