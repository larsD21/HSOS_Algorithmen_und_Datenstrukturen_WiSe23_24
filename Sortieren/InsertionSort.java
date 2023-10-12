package Sortieren;

public class InsertionSort {
    public static void main(String[] args){
        int[] A = {12, 56, 32, 87, 45, 3, 67, 91, 34, 29, 76, 23, 8, 59, 40, 15, 68, 72, 19, 5, 42, 10, 61, 27, 50, 2, 95, 49, 11, 73, 37, 80, 17, 64, 21, 55, 38, 6, 78, 1, 44, 30, 85, 53, 9, 70, 25, 63, 47, 4, 81, 14, 66, 36, 7, 41, 18, 71, 22, 57, 35, 89, 26, 54, 13, 48, 31, 74, 20, 69, 52, 16, 79, 33, 88, 24, 58, 46, 28, 65, 51, 39, 86, 43};
        A = insertionSort(A);
        for(int i : A){
            System.out.println(i);
        }
    }

    private static int[] insertionSort(int[] A){
        for(int j=1; j< A.length; j++){
            int key = A[j];
            int i = j-1;
            while(i>=0 && A[i]>key){
                A[i+1] = A[i];
                i--;
            }
            A[i+1] = key;
        }
        return A;
    }
}
