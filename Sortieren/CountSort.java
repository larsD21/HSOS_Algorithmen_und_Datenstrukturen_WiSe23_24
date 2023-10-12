package Sortieren;

public class CountSort {
    public static void main(String[] args) {
        int[] A = {4, 2, 2, 8, 3, 3, 1};
        int k = 8; // Max in A

        int[] B = new int[A.length];
 
       B = countingSort(A, B, k);
       for(int i : B){
        System.out.println(i);
       }
    }

    private static int[] countingSort(int[] A, int[] B, int k) {
        int[] C = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            C[i] = 0;
        }
        for (int j = 0; j < A.length; j++) {
            C[A[j]] = C[A[j]] + 1;
        }
        for (int i = 1; i <= k; i++) { 
            C[i] = C[i] + C[i - 1];
        }
    
        for (int j = A.length - 1; j >= 0; j--) { 
            B[C[A[j]] - 1] = A[j]; 
            C[A[j]]--;
        }
        return B;
    }
}
