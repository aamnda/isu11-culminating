package u3;

// Method Loading
// The same method name can be defined for a method
// as long as the parameter types and numbers of parameters are different

public class L3_methodOverLoading {

    public static int methodA(int a, int b) {
        if (a>b) return a;
        else return b;
    }

    public static double methodA(double a, double b) {
        if (a>b) return a;
        else return b;
    }

    // This method below would clash with the first methodA since it contains 
    // the SAME name AND parameters
    // public static double methodA(int a, int b) { 
    // }

    //

    public static void main(String[] args) {

        System.out.println(methodA(4,5));
        System.out.println(methodA(3.2, 1.9));

        System.out.println(methodA(3.7, 9)); // executes 9.0 
        // (converts number to double due to converting to an alternative)
        
    }
}