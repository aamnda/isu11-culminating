package u1;

public class L3_printF2 {
    public static void main(String[] args) {

        // vars
        String s = "Markville";
        int n = 23456789;
        double p = 3.1415;
        // double chow = 12345.6789;

        // main code
        // %f <- float holder (by default, any number you replace in the float holder will be rounded to 6 decimals)
        //       
        System.out.printf("Hi %s, %d %f%n", s, n, p); // %n will move cursor to next line (like System.out.println)
        System.out.printf("Hi %s, %d %.3f%n", s, n, p); // rounds the double to 3 decimal places (3.142)

        // string holders
        System.out.printf("%s%n", s);
        System.out.printf("%15s%n", s); // SPACE RESERVATION - max up to 15 spaces ("e" in markvill"e" will line up to the 15th space)
        System.out.printf("%-15s%n", s); // left alignment (negative sign), right alignment (positive sign)

        System.out.printf("%-10s%-15s%-12s%n", "Name", "Hobby", "Fruits");
        System.out.printf("%-10s%-15s%-12s%n", "Alex", "Fishing", "Apples");
        System.out.printf("%-10s%-15s%-12s%n", "Amy", "Reading", "Oranges");
        System.out.printf("%-10s%-15s%-12s%n", "Andy", "Running", "Watermelon");

        // integer holders
        System.out.printf("%d%n", n);
        System.out.printf("%15d%n", n);
        System.out.printf("%-15d%n", n);    
        System.out.printf("%+,-15d%n", n); // comma separator and positive symbol

        System.out.printf("%030d%n",n); // leading 0s fill in empty spaces (only applies for right alignment)
        System.out.printf("%4d%n",n); // since n already has more than 4 digits, space reservation rule doesn't apply

        // float holders
        System.out.printf("%f%n",p);
        System.out.printf("%15.3f%n",p); // rounds up if needed

        System.out.printf("%+015.3f%n",p);




        // practice
        String a = "Hi!";
        int b = 4;
        double num = 3.14159;

        System.out.printf("%%%-5s%+3d%%",a,b); // %Hi!^^^+4%
        System.out.println();

        System.out.printf("\\\"\n\\\"\\\"\\n\""); 
        // \"
        // \"\"n"

        System.out.printf("\\\"\t%%%010.3f\t\t%-5.1f", num, num); // \"^^%000003.142^^^^^3.1^^
        
    }
}