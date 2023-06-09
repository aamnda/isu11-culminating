package u2.assignments.formatives;
import java.util.Scanner;

public class formative4 {
    public static void main(String[] args) {
        
        // // question 1
        // int a = 5;
        // int b = 1;
        // int c = 6;

        // while (b <= 7) {
        //     System.out.printf("%5d", a);
        //     System.out.printf("%5d%n", b);
        //     if (a >= b && a > c)
        //         System.out.printf("%5s", "ONE");
        //     else if (a <= b || b > c)
        //         System.out.printf("%5s", "TWO");
        //     else if (a + 2 >= c)
        //         System.out.printf("%10s", "THREE");
        //     a--;
        //     b += 3;
        // }

        // // question 2
        // int sum = 0;
        // for (int num = 10; num <= 20; num += 3)
        //     sum += num * num;
        // System.out.println(sum);

        // // question 3
        // for (int i = 1; i <= 4; i++) {
        //     for (int j = 4; j >= i; j--) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        // programs for a), b), c), d), e)
        // Find the sum of the cubes of the numbers from 1 to 100.
        int sum = 0;

        for (int i = 1; i <= 100; i++) {
            sum += i;
        }

        // Find the amount to which $1 will grow in ten years at a rate of 8%.
        int money = 1;

        for (int i = 0; i < 10; i++) {
            money *= 1.08;
        }

        // Determine the number of times that a positive integer can be divided by two.
        int num = 100;
        int count = 0;
        
        while (num%2 == 0) {
            count += 1;
            num %= 2;
        }

        // Ask the user for positive integers and sum up all inputs until a value of -1 is read in.

    }
}
