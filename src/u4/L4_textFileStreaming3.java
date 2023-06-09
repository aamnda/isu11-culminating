package u4;

import java.util.Scanner;
import java.io.*;
// The purpose of this program is to stream the text file
// ics3unamelist.txt
// The text file ics3unamelist.txt consists of student names 
// arranged in the following way "last name, first name"
// We want to create a new name list where the student names
// are arranged in the following way "first name, last name"

// To achieve this, we will write a side method called
// swapNames which takes a string in the format:
// "last name, first name"
// and return a string in the format:
// "first name, last name"

public class L4_textFileStreaming3 {

    public static String swapNames(String s) {
        // Local Variables
        String lastName = s.substring(0, s.indexOf(","));
        String firstName = s.substring(s.indexOf(",")+2);

        // swapNames Body
        return firstName + ", " + lastName; 
    }

    public static void main(String[] args) throws IOException{

        // Global Variables
        Scanner inputFile = new Scanner(new File("u4/assets/ics3unamelist.txt"));
        PrintWriter outputFile = new PrintWriter(new FileWriter("u4/assets/newnamelist.txt"));

        // Main Body
        while (inputFile.hasNextLine()) {
            outputFile.println(swapNames(inputFile.nextLine()));
        } 
        inputFile.close();
        outputFile.close();

        System.out.println("DONE!");
    }

}
