package u2;

import java.util.Scanner;

// While loops
// We use a while loop in situations where
// we do NOT know how many times we want to execute a set of commands
// THe number of times is dependent on an underlying condition
// As long as the condition is true, 
// we will continue to execute the set of commands

// If the condition is always met, we will be forever
// stuck inside the while loop. 
// This is called infinite loop.

public class L5_whileLoops {
    public static void main(String[] args) {
        
        // Ask the user for the magic word
        // The user will be asked infinitely until the user answers "please"

        // Variables
        Scanner in = new Scanner(System.in);
        String ans = "";

        // Main Code
        while (!ans.equals("please")){ // While ans is NOT equal to "please"
            System.out.print("What is the magic word? ");
            ans = in.nextLine();
        } 
        // If the condition is NOT satisfied in the while loop
        // The while loop terminates - this is known as breaking out the loop

        System.out.println("That is the magic word!");



        // Use a while loop to display the following sequence
        // -5926
        // -5813
        // -5700
        // ...
        // 133516

        int x = -5926;
        while(x<=133516) {
            System.out.println(x);
            x+=113;
        }

        System.out.println("******************************");
        
        
        // Use a while loop to display the first 16 terms of
        // the sequence (you should not be calculating the 20th term):
        // 1. -8
        // 2. 24
        // 3. -72
        
        int termNum = 1;
        int term = -8;

        while (termNum<=16) {
            System.out.printf("%d. %d%n", termNum, term);

            termNum++;
            term*=-3;
        } 

        // fibonacci sequence
        // display the first 20 terms of the fibonacci sequence
        // 1. 0
        // 2. 1
        // 3. 1
        // 4. 2
        // 5. 3 
        // 6. 5
        // ...
        // 20. ?

        int termNo = 3;
        int firstTerm = 0;
        int secondTerm = 1; 
        int newTerm;

        System.out.printf("%d. %d%n", 1, firstTerm);
        System.out.printf("%d. %d%n", 2, secondTerm);

        while (termNo <= 20) {
            System.out.printf("%d. %d%n", termNo, firstTerm+secondTerm);
            newTerm = firstTerm+secondTerm;
            firstTerm = secondTerm;
            secondTerm = newTerm;

            termNo++;
        }

        in.close();

    }
}
