package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;

        Scanner userInput = new Scanner(System.in);
        gameInstructions("Welcome! I'm thinking numbers from 1-100", "Please select the difficulty");
        System.out.print("Select your difficulty choice: ");
        int difficulty = userInput.nextInt();
        while (difficulty < 1 || difficulty > 3) {
            gameInstructions("You silly! Select the difficulty properly!", "Here's the difficulties you could choose from");
            System.out.print("Select your difficulty choice: ");
            difficulty = userInput.nextInt();
        }

        int attempts = switch (difficulty) {
            case 1 -> {
                System.out.println("You have chosen: Easy difficulty");
                yield 5;
            }
            case 2 -> {
                System.out.println("You have chosen: Hard difficulty");
                yield 3;
            }
            case 3 -> {
                System.out.println("You have chosen: Impossible difficulty");
                yield 1;
            }
            default -> 0;
        };
        boolean isGuessed = false;
        System.out.println("Let's start the game!");
        for (int i = 0; i < attempts; i++) {
            System.out.print("Please input your guess: ");
            int guessedNumber = userInput.nextInt();

            if (guessedNumber < randomNumber) {
                System.out.println("Incorrect! The number is greater than " + guessedNumber);
            } else if (guessedNumber > randomNumber) {
                System.out.println("Incorrect! The number is less than " + guessedNumber);
            } else {
                System.out.printf("Congrats! You've guessed right after %s attempt", i+1);
                isGuessed = true;
                break;
            }
        }

        if (!isGuessed) {
            System.out.print("Want to try again until you get it? (Y/n): ");
            String input = userInput.next();
            if (input.equalsIgnoreCase("y")) {
                System.out.println("Ok! Let's have at it!");
                attempts = 1;
            } else {
                System.out.println("Ok! Have a nice day :)");
            }
        }

        while (!isGuessed) {
            System.out.print("Please input your guess: ");
            int guessedNumber = userInput.nextInt();

            if (guessedNumber < randomNumber) {
                System.out.println("Incorrect! The number is greater than " + guessedNumber);
                attempts++;
            } else if (guessedNumber > randomNumber) {
                System.out.println("Incorrect! The number is less than " + guessedNumber);
                attempts++;
            } else {
                System.out.printf("Congrats! You've guessed right after %s attempt", attempts);
                isGuessed = true;
            }
        }
    }

    private static void gameInstructions(String title, String description) {
        System.out.println(title);
        System.out.println(description);
        System.out.println("1. Easy (5 chances)");
        System.out.println("2. Hard (3 chances)");
        System.out.println("3. Impossible (1 chance)");
    }
}