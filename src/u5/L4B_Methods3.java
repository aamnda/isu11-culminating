package u5;

public class L4B_Methods3 {

    // Write a method called increase1 which takes an integer array
    // ia, the method returns an integer array where
    // all elements in the array is increased by 1

    public static int[] increase1(int[] ia) {
        int[] iaNew = new int[ia.length];
        for (int i = 0; i < ia.length; i++) {
            iaNew[i] = ia[i]+1;
        }
        return iaNew;
    }

    // Write a method called removeString which takes a unique* non-empty 
    // String array sa and a string s. The method returns a String array where
    // s is removed from sa.
    // * a unique array means every element is different
    // removeString({"a","b","c","d",},"c") -> {"a","b","d"}
    // removeString({})
    public static String[] removeString(String[] sa, String s) {
        String[] saNew = new String[sa.length-1];  
        int index = 0;

        for (int i = 0; i < sa.length; i++) {
            if (!(sa[i].equals(s))) {
                saNew[index] = sa[i];
                index+=1;
            }
        }
        return saNew;
    }

    // Write a method called edward, which takes a String array sa 
    // and an integer array ia. THe method returns a character array
    // which consists of the character from the String obtained
    // in sa at the corresponding index obtained in ia
    // edward({"hello","ics3u","comp sci","class"}, {3,2,100,-2})
    // -> {'l','s','',''}
    public static char[] edward(String[] sa, int[] ia) {
        char[] output = new char[sa.length];

        for (int i = 0; i < sa.length; i++) {
            if (ia[i] < sa[i].length() && ia[i]>=0) output[i]=sa[i].charAt(ia[i]);
            else output[i]=' ';
        }
        return output;
    }

    public static void main(String[] args) {
        // int[] ia1 = {1,2,4,9};
        // int[] ia2 = increase1(ia1);
        // String[] sa1 = {"a","b","c","d"};
        // String[] sa2 = removeString(sa1,"c");

        // for (int i = 0; i < ia1.length; i++) {
        //     System.out.println(ia1[i]);
        // }
        // for (int i = 0; i < ia2.length; i++) {
        //     System.out.println(ia2[i]);
        // }

        // for (int i = 0; i < sa2.length; i++) {
        //     System.out.println(sa2[i]);
        // }
        // for (int i = 0; i < sa1.length; i++) {
        //     System.out.println(sa1[i]);
        // }

        String[] sa3 = {"hello","ics3u","comp sci","class"};
        int[] ia3 = {3,2,100,-2};
        char[] ca1 = edward(sa3,ia3);

        for (int i = 0; i < ca1.length; i++) {
            System.out.println(ca1[i]);
        }

    }
}
