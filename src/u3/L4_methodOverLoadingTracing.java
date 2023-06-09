package u3;

public class L4_methodOverLoadingTracing {
    public static int alex(int a, int b) {
        int c = a + b;
        for (   ;c>=a; a++) {
            b -= a;
        }
        return b;
    }

    public static int alex(double a, double b) {
        double c = b - a;
        for (int i = 0; c<=a; c++) {
            System.out.println(c);
        }   
        return (int) c;
    }

    public static void main(String[] args) {
        int a = 3;
        int b = a;

        System.out.println(alex(b,a));
        System.out.println(alex(b,b+1.5)); 
    }
}
