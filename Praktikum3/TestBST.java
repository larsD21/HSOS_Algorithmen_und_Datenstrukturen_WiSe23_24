package Praktikum3;
import java.util.Random;

public class TestBST {
    public static void main(String[] args){
        int[] arr = new int[10000];
        BST bst = new BST();
        for(int i = 0; i<arr.length; i++){
            arr[i] = i;
        }

        arr = randomize(arr, arr.length);

        for(int i = 0; i< arr.length; i++){
            bst.insert(arr[i], Integer.toString(i));
        }

        System.out.println("10000 Elements: " + bst.height());

        for(int i = 1; i<arr.length; i= i+2){
            bst.remove(i);
        }

        System.out.println("5000 Elements: " + bst.height());

        //Manipulate BST
        bst.manipulateValid();
        System.out.println(bst.isValidBST());
    }

    //https://www.geeksforgeeks.org/shuffle-a-given-array-using-fisher-yates-shuffle-algorithm/
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
