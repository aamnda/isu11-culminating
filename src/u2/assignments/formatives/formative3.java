package u2.assignments.formatives;

import java.util.Scanner;

public class formative3 {
    public static void main(String[] args) {

        // System.out.println("----- Question 1 -----");

        // // Variables
        // Scanner in = new Scanner(System.in);
        // int num;
        // int sum=0;

        // // Main code
        // System.out.print("Enter positive integer: ");
        // num = in.nextInt();

        // System.out.printf("%nThe first %d perfect squares are: %n", num);

        // for (int i = 1; i <= num; i++) {
        //     System.out.println(i * i);
        //     sum += (i*i);
        // }

        // System.out.printf("%nThe sum of the first %d perfect squares is: %d", num, sum);

        // in.close();

        // System.out.println("----- Question 3 -----");

        // // Variables
        // int count = 1;

        // for (int i = -5687; i <= 464; i++) {
        //     if (i == 287) {
        //         System.out.printf("287 appears on the %dth term%n", count);
        //     }
        //     else if (i == 464) {
        //         System.out.printf("464 appears on the %dth term", count);
        //     }
        //     count++;
        // }

        System.out.println("----- Question 4 -----");
        
        // Variables
        int secretNum = 9;
        int guess;
        Scanner in = new Scanner(System.in);

        // Main Code
        System.out.println("********** NUMBER MINE GAME *********");
        System.out.println("You have 5 guesses to dodge my mine!!");
        System.out.println("Good Luck...  and Stay Alive...!  >:)");

        System.out.printf("%nGuess #%d: ", 1);
        guess = in.nextInt();

        for (int i = 2; i < 6; i++) {

            if (guess == secretNum) {
                System.out.println("OH NO! OH NO! OH NO NO NO NO NO!");
                i = 5;
            }

            else {

                System.out.printf("Guess #%d: ", i);
                guess = in.nextInt();

            }

        }
        
        if (guess != secretNum) {
            System.out.println("\nYOU GET TO LIVE FOR ANOTHER DAY");
        }

        in.close();

    }
}
