package Sortieren;

public class MergeSort {
    public static void main(String[] args){
        int[] A = {12, 56, 32, 87, 45, 3, 67, 91, 34, 29, 76, 23, 8, 59, 40, 15, 68, 72, 19, 5, 42, 10, 61, 27, 50, 2, 95, 49, 11, 73, 37, 80, 17, 64, 21, 55, 38, 6, 78, 1, 44, 30, 85, 53, 9, 70, 25, 63, 47, 4, 81, 14, 66, 36, 7, 41, 18, 71, 22, 57, 35, 89, 26, 54, 13, 48, 31, 74, 20, 69, 52, 16, 79, 33, 88, 24, 58, 46, 28, 65, 51, 39, 86, 43};
        A = mergeSort(A, 0, A.length-1);
        for(int i : A){
            System.out.println(i);
        }
    }

    private static int[] mergeSort(int[] A,int p,int r){
        if(p < r){
            int q = (p+r)/2;
            A = mergeSort(A, p, q);
            A = mergeSort(A, q+1, r);
            A = merge(A, p, q, r);
        }
        return A;
    }

    public static int[] merge(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
    
        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = A[q + j + 1];
        }
    
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
    
        int i = 0;
        int j = 0;
    
        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }
        return A;
    }
    
}
