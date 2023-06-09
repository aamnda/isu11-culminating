package u2;
import java.util.Scanner;

public class L3_complexCondition {
    public static void main(String[] args) {

        // Ask the user for the latest mark
        // If the mark is greater or equal to 80 - "Good Job"
        // If the mark is between 60 (inclusive) to 80 (exclusive) - "Try Harder"
        // If the mark is between 40 (inclusive) to 60 (exclusive) - "You're Grounded"
        // If the mark is below 40 - "You're disowned"
        
        // Variables
        Scanner s = new Scanner(System.in);
        int mark;

        // Main Code
        System.out.print("What is your latest mark: ");
        mark = s.nextInt();

        if (mark >= 80) {
            System.out.println("Good Job!");
        }
        else if (mark>=60 && mark<80) {
            System.out.println("Try Harder");
        }
        else if (mark>=40 && mark<60) {
            System.out.println("You're Grounded");
        }
        else if (mark<40) {
            System.out.println("You're disowned");
        }

        // Question 1 (Knowledge questions)
        System.out.println("----- Question 1 -----");
        // Determine what will be displayed in the console

        // Variables
        int x = 3;
        double y = 4.5;
        int z = 1;

        // Main Code
        if (x+y < y+z){ // 7.5  // 5.5
            System.out.println("A");
        }
        else if (-z == y/-x) { // -1  // -1.5
            System.out.println("B");
        }
        else if (y-x > z) { // 1.5  // 1
            System.out.println("C");
        }
        else if (x-y > -z) {
            System.out.println("D");
        }
        else if (x+y > 1){
            System.out.println("E");
        }
        else {
            System.out.println("F");
        }

        if (y%x >= y/x) { // 1.5  // 1.5
            System.out.println("G");
        }
        if (Math.pow(z,0) != Math.pow(y,0)) { // 0  // 0 
            System.out.println("H");
        }
        else if (Math.pow(y,x)>Math.pow(5,x)) { // 91.12500  // 125
            System.out.println("I");
        }

        // C
        // G

        // Question 2
        System.out.println("----- Question 2 -----");
        // Determine what will be displayed in the console

        // Variables
        int a = 2;
        int b = 3;
        double c = 4.5;
        int d = 0;
        
        // Main Code
        System.out.println("C");

        if (a+b >= c+b) { // 5  // 7.5
            System.out.println("D");
        }
        else if (b+a > -a+d) { // 5  // -2
            System.out.println("E");
        }
        else if (a+c >= b+d) { 
            System.out.println("F");
        }
        else if (a+d >= b+c) {
            System.out.println("G");
        }
        else{
            System.out.println("H");
        }

        if (c-b == d) { // 0.5  // 0.0
            System.out.println("I");
        }
        else if(b-a == d+1) { // 1  // 1
            System.out.println("J");
        }
        else if (d-a == c-b) {
            System.out.println("K");
        }
        else if (a-b == d-c) {
            System.out.println("L");
        }
        else if (c-a == d-b){
            System.out.println("M");
        }
        
        if (Math.pow(-a, b) == Math.pow(a,b)) { // -8  // 8
            System.out.println("N");
        }

        if (Math.pow(c,b) > Math.pow(a,b)) { // 91.12500  // 8.0
            System.out.println("O");
        }

        if (Math.pow(a,b) > Math.pow(c,b)) { // 8  // 91.12500
            System.out.println("P");
        }
        else if (a+b+c <= d+c+b){ // 9.5  // 7.5
            System.out.println("Q");
            System.out.println("R");
        }
        else if (b+c < a+c) { // 7.5  // 6.5
            System.out.println("S");
            System.out.println("T");
        }
        else if (c+a < c+d) { // 6.5  // 4.5
            System.out.println("U");
            System.out.println("V");
        }
        else if (a+b+d < c) { // 5  // 4.5
            System.out.println("W");
            System.out.println("X");
        }
        System.out.println("Y");
        System.out.println("Z");

        // C
        // E
        // J
        // O
        // Y
        // Z

        s.close();

    }
}
