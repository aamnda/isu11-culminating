package u5;

import java.util.Scanner;
import java.io.*;

// The goal for this program:
// Stream the file marksWithNames.txt
// Add all the first names, last names, term marks, and final exam marks
// into 5 different rrays: firstNameArray, lastNameArray, termArray, examArray, finalArray

// At the end of the program, display:
// All the info from all the arrays
// On the last line, in the console, display
// the average mark

// Write all the info into a new text file called reportCard.txt

// Note: FInal mark = 0.7 * term marks + 0.3 * final exam marks

public class L7_textFileStreaming {

    public static void main(String[] args) throws IOException {
        
        // Variables
        Scanner inputFile = new Scanner(new File("u5/assets/marksWithNames2.txt"));
        PrintWriter outputFile = new PrintWriter(new FileWriter("u5/assets/reportCard.txt"));
        String[] firstNameArray = new String[24];
        String[] lastNameArray = new String[24];
        double[] termArray = new double[24];
        double[] examArray = new double[24];
        double[] finalArray = new double[24];
        double total = 0; 

        // Main Body
        // Skip the first 2 lines in the text file
        inputFile.nextLine();
        inputFile.nextLine();

        for (int i = 0; i < 24; i++) {
            firstNameArray[i] = inputFile.next();
            lastNameArray[i] = inputFile.next();

            termArray[i] = inputFile.nextDouble();
            examArray[i] = inputFile.nextDouble();
            finalArray[i] = termArray[i]*0.7 + examArray[i]*0.3;

            total += finalArray[i];
            
            System.out.printf("%-15s%-15s%-15.1f%-15.1f%-15.1f%n", 
            firstNameArray[i], lastNameArray[i], termArray[i], examArray[i], finalArray[i]);

            outputFile.printf("%-15s%-15s%-15.1f%-15.1f%-15.1f%n", 
            firstNameArray[i], lastNameArray[i], termArray[i], examArray[i], finalArray[i]);
        }

        System.out.printf("Average: %.1f", total/24);
        outputFile.printf("Average: %.1f", total/24);
        inputFile.close();
        outputFile.close();

        System.out.println("DONE!");
    }

}