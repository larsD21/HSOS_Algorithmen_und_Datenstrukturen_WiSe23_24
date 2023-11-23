package Praktikum4;

import java.util.Random;

public class TestRBT {
    public static void main(String[] args){
        RedBlackTree rbt = new RedBlackTree();
        int[] arr = new int[10000];

        for(int i = 0; i< arr.length; i++){
            arr[i] = i;
        }

        arr = randomize(arr, arr.length);

        for (int j : arr) {
            rbt.insert(j, Integer.toString(j));
        }

        System.out.println("Height " + rbt.height());

        System.out.println("Before manipulate " + rbt.checkRB());

        rbt.manipulate();

        System.out.println("After manipulate " + rbt.checkRB());

    }

    // A Function to generate a random permutation of arr[]
    static int[] randomize( int[] arr, int n)
    {
        // Creating a object for Random class
        Random r = new Random();

        // Start from the last element and swap one by one. We don't
        // need to run for the first element that's why i > 0
        for (int i = n-1; i > 0; i--) {

            // Pick a random index from 0 to i
            int j = r.nextInt(i+1);

            // Swap arr[i] with the element at random index
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }
}
