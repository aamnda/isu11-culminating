package u3;

public class L2_programTracing {
    public static int methodA(int n) {
        int a = 1;
        if (n%2 == 0) {
            for (int i = 2; i<=n; i++) { 
                a*=i;
            }
            return a;
        }
        System.out.println("Not Even");
        return n;
    }

    public static int methodB(int a, int b) {
        if (a>b) {
            return a;
        }
        return b;
    }

    public static void main(String[] args) {
        int a = 4;
        int b = 3;
        int c = methodA(a); 
        int d = methodA(b); 

        methodB(c,d); // doesn't display anything
        System.out.println(a+b+c+d);
    }
}


