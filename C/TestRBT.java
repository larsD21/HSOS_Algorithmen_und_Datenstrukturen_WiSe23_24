package C;

import java.util.Random;

public class TestRBT {
    public static void main(String[] args){
        RedBlackTree redBlackTree = new RedBlackTree();
        int[] arr = new int[10000];

        for (int i = 0; i < arr.length; i++){
            arr[i] = i;
        }

        arr = randomize(arr, arr.length);

        for (int i = 0; i < arr.length; i++){
            redBlackTree.insert(arr[i], Integer.toString(arr[i]));
        }


        System.out.println(redBlackTree.height());
        System.out.println(redBlackTree.CheckRB());

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
