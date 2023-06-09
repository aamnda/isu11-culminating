package u2;

public class L6_accumulators {
    public static void main(String[] args) {

        // Use a for loop to calculate the following 
        // 4 + 9 + 16 + ... + 574

        int acc1 = 0;

        for (int i = 4; i <= 574; i += 5) {
            acc1 += i;
        }

        System.out.println(acc1); // 33235

        // Use a while loop to calculate the following:
        // 2 + 6 + 18 + 54 + ... + 39366
        // Display your answer
        
        int acc2 = 0;
        int t2 = 2;

        while (t2 <= 39366) {
            // System.out.println(t2);
            
            acc2 += t2;
            t2 *= 3;
        }

        System.out.println(acc2); // 59048

        // Use a while loop to calculate the following:
        // 32 + 21 + 10 - 1 - 12 - 23 - 34 - ... - 298

        int acc3 = 0;
        int t3 = 32;

        while (t3 >= -298) {
            // System.out.println(t3);

            acc3 += t3;
            t3 -= 11;
        }

        System.out.println(acc3); // -4123

        // Use a for loop to calculate the following:
        // -5 + 10 - 20 + 40 - 80 + ... - 327680
        
        int acc4 = 0;

        for (int i = -5; i != -327680; i *= -2) {
            acc4 += i;
        }
        
        System.out.println(acc4 - 327680); // -218455

    }
}
