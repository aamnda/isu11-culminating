package u4;

import java.io.*;
import java.util.Scanner;

// The text file marksWithNames.txt consists of a bunch of data 
// arranged in the following format:
// firstname, lastname, term marks, culminating marks
// The goal for this program is stream marksWithNames.txt\
// and write into a new Comma Separated Value (CSV) file marksWithNames2.txt
// where the data will be arranged in the following format:
// lastname, firstname, term marks, culminating marks, final grade
// where final grade is made up of 70% of the term marks and 30% of the 
// culminating marks

// 2 new methods
// Integer.parseInt(str) <- Ths converts a String into an integer given that the string can be converted
// eg. Integer.parseInt("54") -> 54

// Double.parseDouble(str) <- This converts a string into a double given that the string can be converted
// eg. Double.parseDouble("12.34") -> 12.34

// If the string cannot be converted into an int/double
// An exception will be thrown


public class L5_textFileStreaming4 {
    
    // firstName method
    // firstName method reads a string s, in the format:
    // firstName lastName termMarks culmMarks
    // The method returns the firstName portion of this String

    public static String firstName(String s) {
        return s.substring(0,s.indexOf(" "));
    }

    // lastName method
    // lastName method reads a String s, in the format:
    // firstName lastName termMarks culMarks
    // The method returns the lastName portion of this string
    
    public static String lastName(String s) {
        s = s.substring(s.indexOf(" ")+1);
        return s.substring(0,s.indexOf(" "));
    }

    // termMarks method
    // termMarks method reads a String s, in the format:
    // firstName lastName termMarks culMarks
    // The method returns the termMarks of this String AS A DOUBLE
    public static double termMarks(String s) {
        s = s.substring(s.indexOf(" ") + 1);
        s = s.substring(s.indexOf(" ") + 1);

        return Double.parseDouble(s.substring(0,s.indexOf(" ")));
    }

    // culmMarks method
    // culmMarks method reads a String s, in the format:
    // firstName lastName termMarks culmMarks
    // The method returns the culmMarks of this String AS A DOUBLE
    public static double culmMarks(String s) {
        s = s.substring(s.lastIndexOf(" ") + 1);
        return Double.parseDouble(s);
    }

    public static void main(String[] args) throws IOException {
        Scanner inputFile = new Scanner(new File("u4/assets/marksWithNames.txt"));
        PrintWriter outputFile = new PrintWriter(new FileWriter("u4/assets/marksWithNames2.csv"));
        String s;

        while (inputFile.hasNextLine()) {
            s = inputFile.nextLine();
            double finalMark = (termMarks(s) * 0.7) + (culmMarks(s) * 0.3);
    
            outputFile.printf("%s, %s, %.1f, %.1f, %.1f%n", lastName(s), firstName(s), termMarks(s), culmMarks(s), finalMark);
        }

        inputFile.close();
        outputFile.close();

    }
}
