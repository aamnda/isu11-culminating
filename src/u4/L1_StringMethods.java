package u4;

public class L1_StringMethods {

    // Write a method removeAE which takes a string s.
    // This method returns a version of s where a, e, A and E
    // are removed
    public static String removeAE(String s) {
        // local variables
        String output = "";

        // removeAE method body
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) !=  'a' && s.charAt(i) != 'A' && s.charAt(i) != 'e' && s.charAt(i) != 'E') {
                output += s.charAt(i);
            }
        }
        return output;
    }

    public static void main(String[] args) {

        String s = "Comp Sci Class";

        // 1) .length()
        // This method returns the number of characters in a string
        System.out.println(s.length());

        // 2) .charAt(#)
        // This method returns the character at position #
        System.out.println(s.charAt(5)); 
        // System.out.println(s.charAt(-1)); // cannot obtain an index below 0
        // System.out.println(s.charAt(14)); // cannot obtain an index that is nonexistent (gives out of bounds exception)

        // 3) .indexOf(str)
        // This method returns the left first occurrence of str if it can be found
        // Otherwise, it'll return -1
        System.out.println(s.indexOf("c"));
        System.out.println(s.indexOf("C"));
        System.out.println(s.indexOf("s"));
        System.out.println(s.indexOf("T"));
        System.out.println(s.indexOf("ci")); // gets position of first char in the str

        // 4) .lastIndexOf(str)
        // This method returns the right first occurrence of str if it can be found
        // Otherwise, it'll return -1
        System.out.println(s.lastIndexOf("C")); // index is still left to right 0-str.length()-1
        System.out.println(s.lastIndexOf("s")); 
        System.out.println(s.lastIndexOf("Chow"));

        // 5) .substring(#1,#2)
        // This method returns the substring of a string 
        // starting from gap #1 to gap #2
        System.out.println(s.substring(5,8));
        System.out.println(s.substring(9,14));
        System.out.println(s.substring(3,4));
        // System.out.println(s.substring(14,9)); // #1 must be smaller than #2
        System.out.println(s.substring(0,0)); // when #1 == #2, it'll return an empty string

        // 6) .substring(#)
        // This method returns the substring from gap # to the end of the string
        // System.out.println(s.substring(9));
        // System.out.println(s.substring(5));

        // 7) .toUpperCase()
        // This method returns the string with all letters converted to upper case
        System.out.println(s.toUpperCase());

        // 8) .toLowerCase()
        // This method returns the string with all letters converted to lower case
        System.out.println(s.toLowerCase());

        // 9) .equals(str)
        // This method returns true if str matches the original string
        // and false otherwise
        System.out.println(s.equals("Comp Sci Class"));

        // Let's try out our method that we wrote above
        System.out.println(removeAE("Hello"));

    }
}
