package u1;

public class L5_tabSpacing {
    public static void main(String[] args) {

        // \t <- tab spacing
        // \t moves the cursor to the next position
        // that is a mutliple of 4

        // Q: What's the purpose of tab spacing?
        // A: Tab-spacing was used for formatting before printf was created 

        System.out.println("0123456789012345678901234567890");
        System.out.println("ab\tcde\tfghi\tjkl"); // different on intellij
        // on intellij -> ab  cde fghi    jkl ****MEMORIZE THIS VERSION FOR TEST
        // on vscode -> ab    cde    fghi    jkl

    }
}
