package u2;

public class L1_booleanOperators {

    // Boolean Operators
    // These are operators that results in a Boolean value

    public static void main(String[] args) {

        // == Equals to 
        System.out.println(3 == 4); // false
        // Similar to adding an integer
        // to a float, if you ever perform
        // any operations that involve a double
        // and an integer, the integer gets
        // converted into a double automatically
        // 3 + 4.5 = 3.0 + 4.5 = 7.5
        System.out.println(5 == 5.0); // true
        // DO NOT USE == ON STRINGS

        System.out.println("abc".equals("abc")); // true
        // to compare two strings, you MUST
        // use the .equals() method

        System.out.println('a'=='A'); // false
        // You can compare chars with the == operator

        // ----------------------------------------------

        // != NOT Equal Operator
        System.out.println(5 != 5); // false
        System.out.println(4.5+3.2 != 1.1); // true

        // -----------------------------------------------

        // < Lesser Than Operator
        System.out.println(4.5 < 9/2); // false (4.5 < 4.0)
        System.out.println(9/2 < 4.5); // true (4.0 < 4.5)

        System.out.println(5 < 5); // false
        
        // -----------------------------------------------

        // <= Lesser Than OR Equal TO Operator
        System.out.println(5 <= 5); // true

        // -----------------------------------------------

        // > Greater Than Operator
        System.out.println('I' > 'A'); // true (increases from A)
        System.out.println('z' > 'a'); // true
        System.out.println('9' > '5'); // true
        System.out.println('h' > 'l'); // false (h is before l)
        System.out.println('S' > 'T'); // false (S is before T)

        System.out.println('a' > 'T'); // lowerscase alphabets come after uppercase

        // ------------------------------------------------

        // >= Greater OR Equal TO Operator
        System.out.println();

        // NOTE:
        // to compare characters:
        // SPACE < Numeric Strings < 'A'-'Z' < 'a'-'z'

    }
}