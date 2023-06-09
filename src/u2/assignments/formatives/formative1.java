package u2.assignments.formatives;
import java.util.Scanner;

public class formative1 {
    public static void main(String[] args) {
        
        // System.out.println(3>5 && 2>1);
        // System.out.println(18==15 || 14<=17);
        // System.out.println(!(27>15));
        // System.out.println(31<51 && 25>=14);
        // System.out.println(32>115 || 12!=12);
        // System.out.println(!(!(52>115) || !false));

        // int first = 34;
        // int second = 24;
        // int third = 24;

        // if (first==second || second==third) 
        //     System.out.print("1");
        // else if (first>second && second>=third)
        //     System.out.print("2");
        // else
        //     System.out.print("3");
        // if (first%3==0)
        //     System.out.print("4");
        
        // Variables
        Scanner in = new Scanner(System.in);
        int a;
        int b;
        int c;
        int d;

        // Main Code
        System.out.println("Please enter three integers: ");
        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();

        System.out.printf("You've entered %d, %d, and %d",a,b,c);
        
        if (a<b && a<c) d = a;
        else if (b<c && b<a) d = b;
        else d = c;

        System.out.printf("The smallest integer is %d", d);

        // Killing/Terminating Variables
        in.close();
        
    }
}
