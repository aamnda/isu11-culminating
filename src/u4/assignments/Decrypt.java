package u4.assignments;

public class Decrypt {

    // Step 1 - Swap every two letters
    public static String step1(String s) { 
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

    // Step 2 - Swap the two characters of the leftest and rightest from the middle of the string
    public static String step2(String s) {
        if (s.length() % 2 == 0) { // even length
            String middleLeft = s.substring(s.length() / 2 - 2, s.length() / 2);
            String middleRight = s.substring(s.length() / 2, s.length() / 2 + 2);

            return s.substring(0, s.length() / 2 - 2) + middleRight + middleLeft + s.substring(s.length() / 2 + 2);
        }

        else {
            String middleLeft = s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
            String middleRight = s.substring(s.length() / 2 + 1, s.length() / 2 + 3);

            return s.substring(0, s.length() / 2 - 1) + middleRight + middleLeft + s.substring(s.length() / 2 + 3);
        }
    }
    
    // Step 3 - Swap the first two characters with the last two
    public static String step3(String s) {
        String firstTwo = s.substring(0, 2);
        String mid = s.substring(2, s.length() - 2);
        String lastTwo = s.substring(s.length() - 2);

        return lastTwo + mid + firstTwo;
    }

    // Step 4 - Move the first half of the string to be last half
    public static String step4(String s) {
        if ((s.length() % 2) == 0)
            s = s.substring(s.length() / 2) + s.substring(0, s.length() / 2); // even length of letters
        else
            s = s.substring(s.length() / 2) + s.substring(0, s.length() / 2); // odd length of letters

        return s;
    }

    // Step 5 - Character Substitutions
    public static String step5(String s) { // for step 5 
        int num;
        String sub = "aj_e_________________to___rxspvi";
        String newStr = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '@' || s.charAt(i) == '=' || s.charAt(i) == '!' || s.charAt(i) == '?'
                    || s.charAt(i) == '*' || s.charAt(i) == '#' || s.charAt(i) == '&' || s.charAt(i) == '$'
                    || s.charAt(i) == '+' || s.charAt(i) == '^' || s.charAt(i) == '%') {
                num = Math.abs(64 - s.charAt(i));
                newStr += sub.charAt(num);
            } else if (s.charAt(i) == '_') {
                newStr += " ";
            } else {
                newStr += s.charAt(i);
            }
        }
        return newStr;
    }
    
    // Step 6 - Change all letters to lowercase

}
