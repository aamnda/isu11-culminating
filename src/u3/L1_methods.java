package u3;

public class L1_methods {

    // public static void is a method
    // that does NOT return any data type
    // void type method is usually used when 
    // the method is used for displaying purposes

    public static void greet(String name) {
        System.out.printf("Hello %s", name);
    } 

    // Write a method isPrime that returns true
    // if an integer greater than 1 is a prime number
    // and false otherwise
    public static boolean isPrime(int n) {

        for (int i=2; i<n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        // The command Math.pow(#, #) is a method
        // The first part "Math" means we are
        // accessing the Math java file

        // Inside the Math java file, there are many 
        // different methods, and pow is one of them

        // Instead of writing 50 lines of code
        // each time we want to find the power
        // of two numbers, we can write these 50 
        // lines ONCE, and then apply it anywhere 
        // we want
        System.out.println(Math.pow(3,4));

        // For example, we want to write a greet method 
        // that displays "Hello _____" everytime we call
        // the method

        greet("Natalie");
        System.out.println(isPrime(9));

    }   
}
