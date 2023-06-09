package u2.assignments.formatives;
import java.util.Scanner;

public class formative2 {
    public static void main(String[] args) {
        
        // Variables
        String name;
        String shift;
        int hours;
        Scanner in = new Scanner(System.in);

        // Main Code
        System.out.print("Enter name: ");
        name = in.nextLine();

        System.out.print("Enter shift: ");
        shift = in.nextLine();

        System.out.print("Enter hours worked: ");
        hours = in.nextInt();

        if (shift.equals("Day")) {
            if (name.equals("Jack")) {
                System.out.printf("You've made %.2f", hours * 15.0);
            } else if (name == "Jill") {
                System.out.printf("You've made %.2f", hours * 17.0);
            }
        }
        else if (shift.equals("Night")) {
            if (name.equals("Jack"))
                System.out.printf("You've made %.2f", hours * 20.0);
            else if (name.equals("Jill"))
                System.out.printf("You've made %.2f", hours * 19.0);
        }

        // Terminating Variables
        in.close();

    }
}
