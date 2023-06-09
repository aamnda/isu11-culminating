package u4;
import java.util.Scanner; 
import java.io.*;

public class L2_textFileStreaming1 {
    // TEXTFILES are PERMANENT data storage

    // Exceptions such as Arithmetic Exceptions
    // and String exceptions are known as default exceptions

    // When streaming text files, there is a possibility 
    // that the file does not exist. However, text file streaming
    // is NOT a default exception, and hence you need to introduce
    // that exception into your program

    public static void main(String[] args) throws IOException {

        // To stream a text file, we need to first create a Scanner
        Scanner inputFile = new Scanner(new File("u4/assets/sample.txt"));
        // To export a text file, we need to create a PrintWriter
        PrintWriter outputFile = new PrintWriter(new FileWriter("u4/assets/sample2.txt"));

        String s;

        while (inputFile.hasNextLine()) {
            s = inputFile.nextLine();
            System.out.println(s);
            outputFile.println("**" + s + "***");
        }

        inputFile.close();
        outputFile.close();

    }
}
