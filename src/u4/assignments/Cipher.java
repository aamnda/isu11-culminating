package u4.assignments;

import java.util.Scanner;
import java.io.*;

// import u4.assignments.Decrypt;
// import u4.assignments.Encrypt;

public class Cipher {

    public static String Encrypt(String s) {

        // step 1 - to uppercase
        s = s.toUpperCase();

        // step 2 - character substitutions
        s = Encrypt.step2(s);

        // step 3 - first half -> last half
        s = Encrypt.step3(s);

        // step 4 - swap 1st 2 chars with last 2
        s = Encrypt.step4(s);

        // step 5 - swap mid two chars
        s = Encrypt.step5(s);

        // step 6 - swap every 2 letters
        s = Encrypt.step6(s);

        return s;
    }

    public static String Decrypt(String s) {

        // Step 1 - Swap every two letters
        s = Decrypt.step1(s);

        // Step 2 - Swap the two characters of the leftest and rightest from the middle of the string
        s = Decrypt.step2(s);

        // Step 3 - Swap the first two characters with the last two
        s = Decrypt.step3(s);

        // Step 4 - Move the first half of the string to be last half
        s = Decrypt.step4(s);

        // Step 5 - Character Substitutions
        s = Decrypt.step5(s);

        // Step 6 - Change all letters to lowercase
        s = s.toLowerCase();

        return s;
    }
    
    public static void main(String[] args) throws IOException {

        // Global Variables (some initiated by user input)
        Scanner inInt = new Scanner(System.in);
        Scanner inStr = new Scanner(System.in);

        System.out.print("Are you encrypting (0) or decrypting (1) an existing file? ");
        int encryptOrDecrypt = inInt.nextInt();
        while (encryptOrDecrypt != 0 && encryptOrDecrypt != 1) {
            System.out.print("Invalid input. Are you encrypting (0) or decrypting (1) and existing file? ");
            encryptOrDecrypt = inInt.nextInt();
        }

        System.out.print("What is the name of the input text file? ");
        String inputTXTName = inStr.nextLine();

        System.out.print("What is the intended name for your output text file? ");
        String outputTXTName = inStr.nextLine();

        Scanner inputFile = new Scanner(new File(inputTXTName));
        PrintWriter outputFile = new PrintWriter(new FileWriter(outputTXTName));

        String s;

        // Main Body Code

        // Encryption Process
        if (encryptOrDecrypt == 0) {
            while (inputFile.hasNextLine()) {
                
                s = inputFile.nextLine();
                outputFile.println(Encrypt(s)); // Stream to new file

            }
        }

        // Decryption Process
        else {
            while (inputFile.hasNextLine()) {

                s = inputFile.nextLine();
                outputFile.println(Decrypt(s));
                
            }
        }

        // Termination of Variables
        inInt.close();
        inStr.close();

        inputFile.close();
        outputFile.close();

        System.out.println("Done");

    }
}
