package u1.assignments;
import java.util.Scanner;

public class receiptGenerator {

    public static String displayHeader(String header) { // displays the ><><>...<><><
        String headerFinal = "";
        for (int i = 0; i < 25; i++) {
            headerFinal = headerFinal + header;
        }
        System.out.println(headerFinal);
        return headerFinal;
    }

    public static void main(String[] args) {

        // variables
        String header = "><"; 
        
        int numOfApples = 0;
        int numOfOranges = 0;
        double amountOfLychees = 0;
        double amountOfBlueberries = 0;

        Scanner in = new Scanner(System.in); // initiating the scanner for user input

        double subtotal;
        double netTotal;

        // main program/code

        // displays the HEADER/TITLE
        displayHeader(header);
        System.out.printf("%36s%n", "Chow Chow Fruit Centre");
        displayHeader(header);

        // the initial prompt/inputs
        System.out.printf("\n%-35s", "Number of apples purchased:");
        numOfApples = in.nextInt();

        System.out.printf("%-35s", "Number of oranges purchased:");
        numOfOranges = in.nextInt();

        System.out.printf("%-35s", "Amount of lychees purchased:");
        amountOfLychees = in.nextDouble();

        System.out.printf("%-35s", "Amount of blueberries purchased:");
        amountOfBlueberries = in.nextDouble();

        in.close();

        // receipt body (description, quantity, price)
        System.out.println();
        for (int i = 0; i < 44; i++) { // displays the title for ----receipt---- 
            if (i == 22) {
                System.out.print("Receipt");
            } else {
                System.out.print("-");
            }
        }
        
        System.out.println("\n\n");

        System.out.printf("%-30s%10s%10s%n", "Description", "Quantity", "Price"); // need to make indent by less spaces for first
        System.out.printf("%-30s%10d%10.2f%n", "Apples @ $0.03/each", numOfApples, 0.83 * numOfApples);
        System.out.printf("%-30s%10d%10.2f%n", "Oranges @ $0.75/each", numOfOranges, 0.75 * numOfOranges);
        System.out.printf("%-30s%10.2f%10.2f%n", "Lychees @ $2.49/lbs", amountOfLychees, 2.49 * amountOfLychees);
        System.out.printf("%-30s%10.2f%10.2f%n", "Blueberries @ $1.42/lbs", amountOfBlueberries, 1.42 * amountOfBlueberries);

        // SUBTOTAL and NET TOTAL
        subtotal = (0.83 * numOfApples) + (0.75 * numOfOranges) + (2.49 * amountOfLychees)
                + (1.42 * amountOfBlueberries);
        netTotal = subtotal * 1.13;

        System.out.printf("\n%40s%10.2f%n", "Subtotal",subtotal);
        System.out.printf("%40s%10.2f%n", "H.S.T. (13%)",
                ((0.83 * numOfApples) + (0.75 * numOfOranges) + (2.49 * amountOfLychees) + (1.42 * amountOfBlueberries))
                        * 0.13);
        System.out.printf("\n%40s%10.2f%n", "Net Total", netTotal);
        
        System.out.println("\n-------THANK YOU FOR SHOPPING WITH US TODAY!------");
    }
}