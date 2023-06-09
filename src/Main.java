import java.io.*;

public class Main {
  public static void main(String[] args) {
    int[] ia1 = {1,2,3,4,5};
    int num = ia1[2];
    ia1[2]=100;
    
    System.out.println(ia1[2]);
    System.out.println(num);
  }
}
