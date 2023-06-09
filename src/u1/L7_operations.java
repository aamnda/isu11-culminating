package u1;

public class L7_operations {
    public static void main(String[] args){

        System.out.println(10/4); // 2
        System.out.println(10.0/4); // 2.5
        System.out.println(10/4.0); // 2.5
        System.out.println(10/2.0); // 5.0
        System.out.println(897/17); // 52

        // Mod operation %
        System.out.println(897%17); // 13

        // there is NO power operation
        // System.out.println(2 ** 3);

        // you cannot multiply a string by an integer (use for loop instead)
        // System.out.println("Hello " * 3);

        // you can add a string to any data type
        // this will simply append the two together
        // as a single string

        System.out.println("Hello"+123); // Hello123

        // test examples
        System.out.println(2*3 + "Hello" + 2*3); // 6Hello6 
        System.out.println(2+3+"Hello"+2+3); // 5Hello23 <-- think of order of cpu processing

    }
}
