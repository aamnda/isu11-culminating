package u2.assignments;
import java.util.Scanner;

// Natalie Wong
// February 28, 2023
// numGuessingGame - Users will continuously guess a number between the range of 1-999 (inclusive)
//                   until the user reaches their limit of 10 tries OR until the user successfully guesses the number.

public class numGuessingGame {
    public static void main(String[] args) {
        
        // Variables
        int secretNum = 59;
        int guessNum;
        Scanner in = new Scanner(System.in);

        // Main Code
        System.out.print("Enter your guess! ");
        guessNum = in.nextInt();

        for (int chances = 10; chances > 0; chances--) {

            if (guessNum != secretNum) {

                if (guessNum > 999 || guessNum < 1) {
                    System.out.print("Invalid Input! Ensure your number is between 1 and 999! ");
                    chances++;
                    guessNum = in.nextInt();
                }

                else if (chances == 1) {
                    System.out.println("Too bad! Try harder next time!");
                }

                else if (guessNum > secretNum) {
                    System.out.printf("Choose a smaller number! You have %d guesses left. ", chances - 1);
                    guessNum = in.nextInt();
                }

                else if (guessNum < secretNum) {
                    System.out.printf("Choose a larger number! You have %d guesses left. ", chances - 1);
                    guessNum = in.nextInt();
                }
            }

            else {
                chances = 0;
                System.out.println("Congratulations! That is the secret number!");
            }
        }
        
        in.close();
    }
}
