package u5;
import java.util.Scanner;
import java.io.*;

// Write a method produceList which takes a String filename
// The method streams the text file filename 
// and returns an integer array consisting of
// numbers inside the text file

public class L8_textFileStreaming2 {
    public static int[] produceList(String filename)  throws IOException{

        // Variables
        Scanner inputFile = new Scanner(new File(filename));
        int[] output;
        int entries = 0;

        // produceList body
        while (inputFile.hasNextLine()) {
            entries++;
            inputFile.nextLine();
        }
        inputFile.close(); // necessary !!!!!!!!!
        output = new int[entries];

        // Read the text file again, but this time
        // storing data into the integer array
        inputFile = new Scanner(new File(filename));
        for (int i = 0; i < entries; i++) {
            output[i]=inputFile.nextInt();
        }

        inputFile.close(); // can choose not to close since method terminates variables automatically
        return output;
    }

    public static void main(String[] args) throws IOException {

        int[] ia1 = produceList("abc.txt");
        int[] ia2 = produceList("def.txt");
        for (int i : ia1) {
            System.out.println(i);
        }
        for (int i : ia2) {
            System.out.println(i);
        }

    }
}
