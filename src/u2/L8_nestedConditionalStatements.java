package u2;
import java.util.Scanner;

public class L8_nestedConditionalStatements {
    // There are two employees at Chow Chow Corporation: "Ava" & "Ben"
    // The following is their pay: 
    // For Ava, her day rate is %15/hour and her night rate is $20/hour
    // For Ben, his day rate is $16/hour and his night rate is %19/hour
    // Write a program to:
    // 1. Ask who the user is
    // 2. Ask whether the user took a day shift or night shift ("Day"/"Night")
    // 3. Ask how many house did they work during their shift (some integer)
    // 4. The computer will generate how much this user made during his/her shift
    public static void main(String[] args) {

        // Variables
        Scanner in = new Scanner(System.in);
        String name;
        String shift;
        int hours;

        // Main Code
        System.out.print("What is your name? ");
        name = in.nextLine();

        System.out.print("Day Or Night shift: ");
        shift = in.nextLine();

        System.out.print("Number of hours: ");
        hours = in.nextInt();

        // In this question, there are four scenarios in which we'd have to cover:
        // 1) Ava and Day
        // 2) Ava and Night
        // 3) Ben and Day
        // 4) Ben and Night

        if (name.equals("Ava")) {
            if (shift.equals("Day")) {
                System.out.printf("You've made: $%.2f", hours*15.0);
            }
            else if (shift.equals("Night")) {
                System.out.printf("You've made: $%.2f", hours*20.0);
            }
        }
        else if (name.equals("Ben")) {
            if (shift.equals("Day")) {
                System.out.printf("You've made: $%.2f", hours*16.0);
            }
            else if (shift.equals("Night")) {
                System.out.printf("You've made: $%.2f", hours*19.0);
            }
        }



    }
}