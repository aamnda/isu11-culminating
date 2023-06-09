
package u1;
import java.util.Scanner;

public class L2_printF {
    public static void main(String[] args) {

        // two ways to print learnt so far:
        // System.out.println <-- displays the message, positions cursor on the next line
        // System.out.println <-- displays the message, positions cursor on end of same line

        // vars 
        Scanner in = new Scanner(System.in);
        String name;
        String school;
        int grade;
        int age;
        
        // main
        System.out.print("What is your name? ");
        name = in.nextLine();

        System.out.print("How old are you? ");
        age = in.nextInt();

        System.out.print("Which school do you go to? ");
        in.nextLine(); // line skip burner
        school = in.nextLine();

        System.out.print("What grade are you in? ");
        in.nextInt(); // line skip burner
        grade = in.nextInt();

        System.out.printf("Hello %s! You are $d years old. You go to $s and you are in grade $d", name, age, school, grade);

        // System.out.println("Hello " + name + "! You are " + age + " years old!");
        // System.out.printf("Hello %f! You are %d years old", name, age);
        in.close();
    }
}
