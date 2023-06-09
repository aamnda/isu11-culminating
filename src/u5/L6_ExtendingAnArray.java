package u5;

import javax.swing.event.SwingPropertyChangeSupport;

public class L6_ExtendingAnArray {

    // Write a method called extendArray which takes an integer array ia
    // and an integer n.
    // The method returns an integer array with all the elements of 
    // ia plus the new element n
    // extendArray({3,2,1,4,5},9) -> {3,2,1,4,5,9}
    // 4-step process: !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // 1) Create an array with ONE more element than the original array
    // 2) Copy all the elements from the old array into the new array
    // 3) Write the new element into the last index of the array
    // 4) Return the array

    // As we know, an array has a fixed number of elements
    // after you've declared an array

    public static int[] extendArray(int[] ia, int n) {
        int[] output = new int[ia.length + 1];

        for (int i = 0; i < ia.length; i++) {
            output[i]=ia[i];
        }
        output[output.length-1] = n;
        return output;
    }

    public static void main(String[] args) {
        int[] ia = {3,2,5,9}; 
        ia = extendArray(ia,100); // {3,2,5,9} is now in the java garbage collection 

        for (int i : ia) { // : in 
            System.out.println(i);
        }
    }

    // Java Garbage Collection
    // Any objects that no longer has access points will be eliminated from the RAM
}