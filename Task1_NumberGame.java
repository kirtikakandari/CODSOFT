import java.util.Random;
import java.util.Scanner;
public class Task1_NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

    int round = 1;
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have 5 attempts to guess the number.");

    boolean playAgain = true;
        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; 
            int totalattempts = 5;
            int attemptsleft = 0;
            boolean hasGuessedCorrectly = false;
        
    
        System.out.println("Round " + round + ":");
        System.out.println("guess the number between 1 and 100.");

        while (totalattempts > 0 && !hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            totalattempts--;
            attemptsleft++;

            if (userGuess < 1 || userGuess > 100) {
                System.out.println("Please guess a number between 1 and 100.");
            } else if (userGuess < numberToGuess) {
                System.out.println("Too low.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high.");
            } else {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You've guessed the number " + numberToGuess + " in " + attemptsleft + " attempts.");
            }
        }
        
        System.out.print("Do you want to play again? (yes/no): ");
        String response = scanner.next();
        if (response.equalsIgnoreCase("yes")) {
            round++;
        } else {
            playAgain = false;
            System.out.println("Thank you for playing! Goodbye!");
        }
        }
        scanner.close();
    }
}