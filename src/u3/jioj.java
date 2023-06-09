package u3;

public class jioj {

    public static int roundResultDoubleToInt(double n) {
        return (int) n; // never rounds up when .>5
    }

    public static void main(String[] args) {
        System.out.println(roundResultDoubleToInt(4.7)); // returns 4

        int a = 34;
        boolean aRange = a>30 && a<40;
        System.out.println(aRange);
    }
}
