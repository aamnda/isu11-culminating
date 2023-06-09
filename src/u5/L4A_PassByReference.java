package u5;

public class L4A_PassByReference {
    public static void main(String[] args) {
        // Pass-by-Value
        int a = 5;
        int b = a; // The value of a is copied over to b
        a += 3;
        System.out.println(b);

        // Pass-by-reference
        int[] ia1 = {1,2,3,4,5};
        int[] ia2 = ia1; // The memory location of a is copied over to b
                         // In this case, a and b both share the same 
                         // memory location (reference point)
        ia1[2] = 9;
        System.out.println(ia2[2]); // 9
        ia2[4] = 0;
        System.out.println(ia1[4]); // 0
    }
}
