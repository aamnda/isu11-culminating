package u5;

// Write a method genArr which takes an integer n
// The method creates an integer array with n elements
// where the n elements form an arithmetic series
// starting with 0, and a finite difference of 2

public class L3_Methods2 {

    public static int[] genArr(int n) {
        // Variables
        int[] output = new int[n];

        // genArr Body
        for (int i = 0; i < n; i++) {
            output[i] = i*2;
        }

        return output;
    }

    // Write a method called fibonacci which takes a positive integer n
    // The method returns an integer array that contains the first n
    // terms of the fibonacci sequence
    public static int[] fibonacci(int n) {
        // Variables
        int[] output = new int[n];
        
        if (n>=2) {
            output[0] = 0;
            output[1] = 1;

            for (int i = 2; i < n; i++) {
                output[i] = output[i-1] + output[i-2];
            }
        }

        else if (n==1) {
            output[0] = 0;
        }
        
        return output;
    }

    // Write a method called genCharArr which takes a String s
    // and an integer n
    // The method creates a char array which constist of the first
    // n characters of s
    // genCharArr("Hello Mr. Chow", 5); -> {"H","e","l","l","o"}
    // genCharArr("apple", 8) -> {"a","p","p","l","e"}
    public static char[] genCharArr(String s, int n) {
        // Variables
        char[] output = new char[Math.min(n, s.length())];

        // genCharArr Body
        for (int i = 0; i < output.length; i++) {
            output[i] = s.charAt(i);
        }
        return output;
    }

    public static void main(String[] args) {
        int[] intArr1 = genArr(4);
        int[] intArr2 = genArr(6);

        int[] intArr3 = fibonacci(7);

        for (int i = 0; i < intArr1.length; i++) {
            System.out.println(intArr1[i]);
        }

        for (int i = 0; i < intArr2.length; i++) {
            System.out.println(intArr2[i]);
        }

        for (int i = 0; i < intArr3.length; i++) {
            System.out.println(intArr3[i]);
        }

    }
}
