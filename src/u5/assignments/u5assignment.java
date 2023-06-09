package u5.assignments;

import java.util.Scanner;
import java.io.*;

// Natalie Wong
// May 17th, 2023

// This program is purposed towards documenting the individual sales 
// transactions and bonuses for each employee of ChowTech Inc. into 
// a single txt file.

public class u5assignment {

    public static int[] addVal(int[] x, int y) { // for increasing employees array
        int[] output = new int[x.length + 1];
        for (int i = 0; i < x.length; i++) {
            output[i] = x[i];
        }
        output[x.length] = y;

        return output;
    }

    public static double[] addVal(double[] x, double y) { // for increasing sales array
        double[] output = new double[x.length + 1];
        for (int i = 0; i < x.length; i++) {
            output[i] = x[i];
        }
        output[x.length] = y;

        return output;
    }

    public static void main(String[] args) throws IOException {

        // Main Variables
        Scanner in = new Scanner(System.in);
        int year;
        int employee;
        double sale;
        boolean employeeExists = false;
        int[] employees = {};
        double[] sales = {};
        double totalSales = 0;
        double totalBonus = 0;

        // Main Body
        System.out.print("Year: ");
        year = in.nextInt();

        Scanner inputFile = new Scanner(new File(year+"_sales_summary.txt"));
        PrintWriter outputFile = new PrintWriter(new FileWriter(year+"_bonus_summary.txt"));

        outputFile.println("Employee ID    Sales Total   Bonus Total");
        outputFile.println("****************************************");

        inputFile.nextLine(); 
        inputFile.nextLine(); // skip first two lines

        while (inputFile.hasNextLine()) {
            
            employee = inputFile.nextInt();
            sale = inputFile.nextDouble();

            for (int i = 0; i < employees.length; i++) {
                if (employees[i] == employee) { // if employee is already registered into the employees array
                                                // increase their sales amount (same index)
                    sales[i] += sale;
                    employeeExists = true;
                    break;
                }
            }

            if (!employeeExists) { // if employee wasn't registered into the employees array yet,
                                   // add their employee id into the employees array and at the same
                                   // index, document their initial sales amount
                employees = addVal(employees, employee);
                sales = addVal(sales, sale);
            }
            employeeExists = false;

            // System.out.println(1);
        }
        
        for (int i = 0; i < employees.length; i++) {
            outputFile.printf("%-15d", employees[i]);

            outputFile.printf("%11.2f", sales[i]);
            totalSales += sales[i];

            outputFile.printf("%14.2f%n", sales[i] * 0.05);
            totalBonus += sales[i] * 0.05;
        }

        // outputFile.printf("%-15d", employee);
        // outputFile.printf("%11.2f",sales);
        // outputFile.printf("%14.2f%n",sale*0.05);

        outputFile.println("****************************************");
        outputFile.printf("Number of Employees: %d%n", employees.length);
        outputFile.printf("Sales Total: %.2f%n", totalSales);
        outputFile.printf("Bonus Total: %.2f%n", totalBonus);

        in.close();
        inputFile.close();
        outputFile.close();

        System.out.println("DONE");

    }
}
