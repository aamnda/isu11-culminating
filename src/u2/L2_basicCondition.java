package u2;
import java.util.Scanner;
// Write a program where the user answers the question:
// What is your mark on your latest test
// If the user answers a number that is 80 or above
// Respond with "GOOD JOB!"
// Otherwise
// Respond with "YOU'RE GROUNDED"

public class L2_basicCondition {
    public static void main(String[] args) {
        
        // Variables
        Scanner s = new Scanner(System.in);
        int mark;

        // Main code
        System.out.print("What is your most recent mark: ");
        mark = s.nextInt();

        if (mark >= 80) { // condition (T/F) goes inside bracket

            // You can have no curly brackets if it's just 
            // a single command, but this is not allowed if
            // it has more than one command

            System.out.println("GOOD JOB!"); 
        }
        else {
            System.out.println("YOU'RE GROUNDED");
        }

        // Determine what the following program
        // will display
        
        // Variables
        // int x = 3;
        // int y = 4;

        // // Main
        // if (x == y){ // false
        //     System.out.print("A");
        // }
        // else { // true
        //     System.out.print("B");
        // }

        // System.out.print("C");

        // if (x*y >= y) { // true
        //     System.out.print("D");
        // }

        // if (-x >= -y) { // true
        //     System.out.print("E");
        // }

        // if (y%x == y-x) { // true
        //     System.out.print("F");
        // }
        // else { 
        //     System.out.print("G");
        // }
        // BCDEF

        // variables
        int x = 5;
        int y = 3;

        // Main COde
        if (x-3 >= x/y) System.out.println("\\\""); // true
        if(Math.pow(5,3) <= Math.pow(3,5)) System.out.printf("%.2f%n",x*1.0/y);
        else {
            System.out.printf("%.2f%n",x*1.0/y);
        }

        if (x*1.0/y > x/y) System.out.printf("%5s","CS");
        else 
            System.out.printf("%-5s","CS");

        if (Math.abs(y-x) == Math.abs(x-y)) 
            System.out.print("be careful");

        if(Math.max(5,3)>x)
            System.out.print("of line skip");
            System.out.println("after printf"); // on test

        // \"
        // 1.67
        // ^^^CSbe carefulafter printf
        
        s.close();
        
    }   
}