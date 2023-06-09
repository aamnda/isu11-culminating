package u5;

// Write a method called sumArray
// Which takes an array of integers
// and returns the sum of all the integers

// Write a method called oddCount
// which takes an array of integers
// and return the number of odd integers

// Write a method called stringGen
// which takes a String array sa and an integer n
// The method returns a String where the nth 
// position of every string in sa are concatenated
// stringGen({"Hello", "ICS20", "Class", "MSS"},2) -> lSaS
// stringGen({"apples","bananas","grapes","watermelon"},6) -> "se"

public class L2_Methods1 {

    // We can find the number of elements in an array arr
    // by calling arr.length  <- Note that there is NO bracketsr

    // sumArray method
    public static int sumArray(int[] ia) {
        // Variables
        int acc = 0;

        // sumArray Body
        for(int i = 0; i<ia.length; i++) {
            acc += ia[i];
        }
        return acc;
    }

    // oddCount method
    public static int oddCount(int[] ia) {
        // Variables
        int acc = 0;

        // oddCount Body
        for (int i = 0; i<ia.length; i++) {
            if (ia[i]%2 != 0) {
                acc +=1;
            }
        }
        return acc;
    }

    public static String stringGen(String[] sa, int n) {
        // Variables
        String newStr = "";
            
        // stringGen Body
        for (int i = 0; i<sa.length; i++) {
            if (sa[i].length() > n) {
                newStr += sa[i].charAt(n);
            }
        }
        return newStr;
    }

    public static void main(String[] args) {

        // Global Variables
        int[] intArr1 = {-3,9,4,2,5,7};
        int[] intArr2 = {-5,0,5};

        String[] strArr1 = {"Hello", "ICS20", "Class", "MSS"};
        String[] strArr2 = {"apples","bananas","grapes","watermelon"};

        // Main Body
        System.out.println(sumArray(intArr1));
        System.out.println(sumArray(intArr2));

        System.out.println(oddCount(intArr1));
        System.out.println(oddCount(intArr2));

        System.out.println(stringGen(strArr1,2));
        System.out.println(stringGen(strArr2, 6));

    }
}
