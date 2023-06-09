package u1;
import java.util.Scanner;

public class L1_IntroductionToJava {

    // this is known as the MAIN method
    // the main method is gthe frst look for any java files
    // the computer ALWAYS start executing from the MAIN method

    public static void main(String[] args) {

        // To capture user input in JAVA
        // It is FAR more complicated than codeHS

        // initiatize a scanner object that allows for keyboard detection
        // System.in <-> computer keyboard
        Scanner in = new Scanner(System.in); 

        System.out.print("What is your name? "); // System.out.print retains the cursor to the same line
        String name = in.nextLine();

        System.out.print("How old are you? ");
        int age = in.nextInt();

        System.out.println("Hi " + name + ". You are " + age + " years old.");

        in.close();
    }
}
