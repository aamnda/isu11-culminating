package u2;

public class L4_forLoops {
    public static void main(String[] args){

        // Purpose: to repeat a set of commands
        // a fix number of times
        // eg. print "Hello" ten times

        // for loop consists of three parts:
        // 1) Local Variable(s) Initialization
        // 2) Condition
        // 3) Increment factor
        for (int i = 1; i<=10; i++) {
            System.out.println("Hello");
        }

        // eg. print from 1 to 10
        for(int i = 1; i<11; i++) {
            System.out.println(i);
        }

        // eg. (grade 11 math) display the following
        // -123
        // -91
        // -59
        // ...
        // 229
        // arithmetic sequence

        for(int i = -123; i<=229; i=i+32){
            System.out.println(i);
        }

        // eg. (grade 11 math) display the following
        // 3515625
        // 703125
        // ...
        // 9
        
        for(int i = 3515625; i>=9; i/=5) {
            System.out.println(i);
        }

        // eg. display the following sequences
        // 3
        // -6
        // 12
        // ..
        // -98304

        for (int i = 3; i>=-98304 && i!=-98304*-2; i*=-2){
            System.out.println(i);
        }

    }
}
