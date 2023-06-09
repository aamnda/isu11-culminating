package u1;

public class L4_specialCharacters {
    public static void main(String[] args) {

        // question:    if strings are bounded by double quotation marks ""
        //              How would I display " in a print command

        // answer:      using an escape key (back slash)
        //      in this course we will cover four special characters:
        //      \\ <- displays one backslash symbol
        //      \" <- displays the " mark
        //      \n <- skips a line
        //      \t <- creates a tab

        System.out.println("I want to type \"\""); // I want to type ""
        System.out.println("I want to type \\"); // I want to type \
        System.out.println("Mark\nville"); 
        // Mark
        // ville

        System.out.println("\\\"\\\"\nnn\n\"\\\"\\"); 
        // \"\"
        // nn
        // "\"\

        // to skip a line using printf,
        // you can use BOTH %n or \n
        System.out.printf("Mark%nville"); 
        // however, %n is only for printf
        System.out.println("Mark%nville");

        // since % is reserved for printf
        // How would I display the % symbol
        // using the printf symbol??
        // eg. Display %s in the console
        System.out.printf("%%s"); // %% prints one % in printf

    }
}
