package u4;
import java.util.Scanner;
import java.io.*;

public class L3_textFileStreaming2 {

    // Goal for this program:
    // Stream the file marks.txt and calculate the average of all the marks
    // in the text file. Create a new text file called "marks2.txt"
    // copy all the entries from marks.txt to marks2.txt 
    // add the average of all entries into mark2.txt

    public static void main(String[] args) throws IOException {

        // Global Variables
        Scanner inputFile = new Scanner(new File("u4/assets/marks.txt"));
        PrintWriter outputFile = new PrintWriter(new FileWriter("u4/assets/marks2.txt"));

        double total = 0;
        int entries = 0;
        double mark;

        while (inputFile.hasNextLine()) { 
            mark = inputFile.nextDouble();

            entries += 1;
            total += mark;
            outputFile.println(mark);
        }

        outputFile.print("Average: " + total/entries);

        inputFile.close();
        outputFile.close();

    }
}
