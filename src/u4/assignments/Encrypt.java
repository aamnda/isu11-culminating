package u4.assignments;

// import java.util.Scanner;
// import java.io.*;

public class Encrypt {
    
    // Step 1 - Change all letters to uppercase

    // Step 2 - Character substitutions
    public static String step2(String s) { // for step 2
        int num;
        String sub = "@___=___!?____*#_&$+_^_%";
        String newStr = "";
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'J'
                    || s.charAt(i) == 'O' || s.charAt(i) == 'P' || s.charAt(i) == 'R' || s.charAt(i) == 'S'
                    || s.charAt(i) == 'T' || s.charAt(i) == 'V' || s.charAt(i) == 'X') {

                num = s.charAt(i) - 65;
                newStr += sub.charAt(num);
            }
            else if (s.charAt(i) == ' ') {
                newStr += "_";
            }
            else {
                newStr += s.charAt(i);
            }
        }
        return newStr;

    }

    // Step 3 - Move the first half of the string to be the last half
    public static String step3(String s) {
        if ((s.length() % 2) == 0)
            s = s.substring(s.length() / 2) + s.substring(0, s.length() / 2); // even length of letters
        else
            s = s.substring(s.length() / 2 + 1) + s.substring(0, s.length() / 2 + 1); // odd length of letters

        return s;
    }

    // Step 4 - Swap the first two characters with the last two
    public static String step4(String s) {
        String firstTwo = s.substring(0, 2);
        String mid = s.substring(2, s.length() - 2);
        String lastTwo = s.substring(s.length() - 2);

        return lastTwo + mid + firstTwo;
    }
    
    // Step 5 - Swap the two characters of the leftest and rightest from the middle of the string
    public static String step5(String s) { 
        if (s.length() % 2 == 0) { // even length
            String middleLeft = s.substring(s.length() / 2 - 2, s.length() / 2);
            String middleRight = s.substring(s.length() / 2, s.length() / 2 + 2);

            return s.substring(0, s.length() / 2 - 2) + middleRight + middleLeft + s.substring(s.length() / 2 + 2);
        } else {
            String middleLeft = s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
            String middleRight = s.substring(s.length() / 2 + 1, s.length() / 2 + 3);

            return s.substring(0, s.length() / 2 - 1) + middleRight + middleLeft + s.substring(s.length() / 2 + 3);
        }
    }
    
    // Step 6 - Swap every two letters
    public static String step6(String s) { 
        String newStr = "";

        for (int i = 0; i < s.length(); i += 2) {
            if (i == s.length() - 1) {
                newStr += s.charAt(i);
            } else {
                newStr += s.charAt(i + 1);
                newStr += s.charAt(i);
            }
        }
        return newStr;
    }

}
