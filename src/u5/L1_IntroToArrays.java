package u5;

public class L1_IntroToArrays
 {
    public static void main(String[] args) {

        // Suppose I want to store 5 names
        // There are two ways to achieve this:
        // 1) Declare 5 String Variables
        // 2) Declare ONE String array

        String[] names = {"Alexander", "Pranav", "Lucas", "Amanda", "Natalie"};
        System.out.println(names[2]); // Lucas

        System.out.println(names[1]); // Pranav
        names[1] = "Henry"; // replaces "Pranav" with "Henry"
        System.out.println(names[1]);

        // There is no quick way to print out the entire
        // array (UNLIKE python)
        System.out.println(names);
        // If you try to print out the array
        // You get a RAM access point of where
        // the array is located

        // If you want to print out the entire 
        // array, unofrtunately the only way 
        // to do this is using a FOR-LOOP
        for (int i = 0; i <= 4; i++) {
            System.out.println(names[i]);
        }

        // Unlike Python where you can EASILY
        // add an element to an array
        // Java (as well of 90% of the languages out there)
        // does not allow you to extend the size of the array
        // once it has been declared
        // NOT SAVING IT CANNOT BE DONE, but there's no quick
        // way of doing it


    }
 }