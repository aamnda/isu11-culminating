package u4;

import java.util.Scanner;
import java.io.*;

// Purpose of this lesson:
// dates.txt contains MANY lines of dates in the format of 
// MMDD
// Mr. Chow does not like this format and wishes to convert
// all the dates to MMM DD, where MMM corresponds to the first
// 3 letters of the month
// Write the new dates into the file dates2.txt

// Hint:
// 1) Integer.parseInt("000123") -> 123
// 2) You do NOT need 12 if-statements to do this question

public class L6_textFileStreaming5 {

    public static String convertDate(String s) {
        String output;
        String months = "JANFEBMARAPRMAYJUNJULAUGSEPOCTNOVDEC";

        // Month
        int month = Integer.parseInt(s.substring(0,2));
        output = months.substring((month*3)-3,month*3);

        int date = Integer.parseInt(s.substring(2));
        output += " " + date;

        return output;

    }

    public static void main(String[] args) throws IOException {

        // Global Variables
        Scanner inputFile = new Scanner(new File("u4/assets/dates.txt"));
        PrintWriter outputFile = new PrintWriter(new FileWriter("u4/assets/dates2.txt"));
        
        // Main Body Code
        while (inputFile.hasNextLine()) {
            outputFile.println(convertDate(inputFile.nextLine()));
        }

        // Terminating variables
        inputFile.close();
        outputFile.close();

    }
}
