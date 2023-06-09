package u5;

public class L5_Methods4 {

    // Helper Methods

    // Write a method called countOccurrences which takes a String
    // array sa and a character array ca.
    // The method returns an integer array where each elements
    // corresponds to the number of times an element in ca
    // appeared in sa
    // countOccurrences({"Hello","ICS20","computer"}, {'l','C','!'})   ->   {2,1,0}

    // Write a method called countOccurrenceHelper
    // a String s and a character c 
    // The method returns the number of times c appeared in s


    public static int[] countOccurrences(String[] sa, char[] ca) {
        int[] output = new int[sa.length];

        for (int i = 0; i < sa.length; i++) {
            output[i] = countOccurrencesHelper(sa[i], ca[i]);
        }
        return output;
    }

    public static int countOccurrencesHelper(String s, char c) {
        int acc = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==c) acc+=1;
        }

        return acc;
    }

    public static void main(String[] args) {
        
        String[] sa = {"Hello","ICS20","computer"};
        char[] ca = {'l','C','!'};
        int[] ia = countOccurrences(sa, ca);

        for (int i : ia) {
            System.out.println(i);
        }
    }
}
