import java.util.Scanner;
import java.util.Random;

public class GuessingGame {

    public static void main(String[] args) {
        startGame(205, 10); // Set the range from 0 to 500 and up to 10 attempts
    }

    public static void startGame(int maxNumber, int maxTries) {

        Scanner reader = new Scanner(System.in);
        Random random = new Random();

        int numberGenerator = random.nextInt(maxNumber + 1);
        int tryOuts = 0;
        boolean right = false;

        System.out.println("Welcome to the Guessing Game! Try your luck to guess the number between 0 and " + maxNumber + ".");
        System.out.println("You have " + maxTries + " tries.");

        // Start main loop
        while (tryOuts < maxTries) {
            System.out.print("Type a number between 0 and " + maxNumber + ": ");

            // User validation for only numbers typed
            while (!reader.hasNextInt()) {
                System.out.print("Type a valid number between 0 and " + maxNumber + ": ");
                reader.next();
            }

            int typedNumber = reader.nextInt();
            tryOuts++;

            // Check if the numbers it's in the allowed range
            if (typedNumber < 0 || typedNumber > maxNumber) {
                System.out.println("Number out! Try again.");
                continue; // Restart the loop for the next try
            }

            if (typedNumber == numberGenerator) {
                System.out.println("Congratulations!! You've guessed the number in " + tryOuts + " trys!");
                right = true;
                break; // break the loop when the right number is typed
            } else if (typedNumber < numberGenerator) {
                System.out.println("The number typed is lower than the number generated");
            } else {
                System.out.println("The number typed is higher than the number generated.");
            }

            // Hint fml
            if (Math.abs(numberGenerator - typedNumber) <= 10) {
                System.out.println("Hint: You're very close!");
            }
        }

        // If user don't guess in maxTries
        if (!right) {
            System.out.println("You've run out of tries. The number was: " + numberGenerator);
        }

        // Option to play again
        System.out.println("Do you want to play again? (Y/N): ");
        char answer = reader.next().toUpperCase().charAt(0);

        if (answer == 'Y') {
            startGame(maxNumber, maxTries);
        } else {
            System.out.println("Thank you for playing!");
            reader.close(); // Close Scanner
        }
    }
}
