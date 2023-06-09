package u2;
import java.util.Scanner;

public class L7_compoundBooleanStatements {
    public static void main(String[] args) {

        // Boolean Operators
        // && Operator
        // || Operator
        // The above boolean operators take on two boolean arguments
        
        // && operator
        // The && operator results true if the two sttaements are true.
        // true && true -> true
        // true && false -> false
        // false && true -> false
        // false && false -> false

        // || operator
        // The || operator results true if one of the two statements is true
        // true || true -> true
        // true || false -> true
        // false || true -> true
        // false || false -> false

        // Example 1 - Evaluate the following
        // !(true && false) || (false || false)
        // !(false) || (false)
        // true || false
        // true
        System.out.println(!(true && false) || (false || false)); // true

        // Example 2 - Evaluate the following
        // !(true && true) || !false
        // false || true
        // true
        System.out.println(!((true || false) && (false || true)) || !(true && false)); // false

        // Example 3 - Evaluate the following
        int x = 5;
        int y = 4;
        boolean z = false;

        // 625<=1024 && !(false || 1>-1)
        // true && false
        // false
        System.out.println((Math.pow(5,4) <= Math.pow(4,5)) && !(!(!z) || x-y > y-x));

        // Example 4 = Write the following program
        // Write a program that asks the user for an integer:
        // If the number is NOT positive NOR is the number is a multiple of 3
        // Display "Option A"
        // If the number is NOT negative, BUT the number is even
        // Display "Option B"
        // Otherwise, display "Option C"

        // Note 1: NOT A NOR B -> NOT A AND NOT B
        // Note 2: NOT A BUT B -> NOT A AND B 

        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = in.nextInt();

        if (!(num > 0) && !(num%3 == 0)) {
            System.out.println("Option A");
        }
        else if (!(num < 0) && num%2 == 0) {
            System.out.println("Option B");
        }
        else {
            System.out.println("Option C");
        }

    }
}
