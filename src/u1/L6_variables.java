package u1;

// variables are memory boxes that are created 
// in the ram to store data values.

public class L6_variables {
    public static void main(String[] args) {

        // the command below will store the number 8
        // to the integer portion of the RAM, with a 
        // reference name called num
        double num = 8; // saves as 8.0

        // There are certain rules to the naming convention for variables:
        // 1) first letter of the variable must be lower case 
        // 2) can't name it using pre-existing commands/words
        // 3) you must start your variable name with a letter
        // 4) you cannot have spaces
        // 5) if your variable name consists of multiple words, use camel casing (eg. camelCasing)
        // 6) 
        
        // camel casing
        // suppose we want to declare a new variable
        // called "mister chow special number"
        int misterChowSpecialNumber = 88;

        // suppose I want to increase num by the number stored in misterChowSpecialNumber
        // value reassignment
        num = num + misterChowSpecialNumber; // or num += misterChowSpecialNumber;
        num -= 90; // takes away 90 from the value
        // += -= *= /=
        System.out.println(num);

        // increment operator
        // to increase a variable value by 1
        // you can use the ++ symbol
        // the command below is the same as:
        // num = num + 1;
        // num += 1;
        num++;

        System.out.println(num+misterChowSpecialNumber); // 96 + 88

        num = 100;
        System.out.println(num++); // num++ takes place after the whole command is executed

        num = 100;
        System.out.println(++num); // ++num takes place before the whole command executes

        misterChowSpecialNumber += ++num; // 88 + 2

    }
}
