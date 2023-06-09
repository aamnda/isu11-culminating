package u1;

public class printf {
    public static void main(String[] args) {
        System.out.printf("%%s%n"); 

        System.out.printf("%%%%%s\n%%%n%s", "%%%s%%", "%\n%n%%");

        // %s
        // %%%%%s%%
        // %
        // %
        // %n%%

        System.out.printf("\"\t\\%%%n\t\\%5s\\\"%10s", "%%%%", "%n\n%%\"\t\\");
        // "^^^\%
        // ^^^^\^%%%%\"%n
        // %%"^\\

    }
}
