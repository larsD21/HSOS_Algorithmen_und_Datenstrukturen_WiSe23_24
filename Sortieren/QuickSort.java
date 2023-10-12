package Sortieren;

public class QuickSort {
    public static void main(String[] args){
        int[] A = {12, 56, 32, 87, 45, 3, 67, 91, 34, 29, 76, 23, 8, 59, 40, 15, 68, 72, 19, 5, 42, 10, 61, 27, 50, 2, 95, 49, 11, 73, 37, 80, 17, 64, 21, 55, 38, 6, 78, 1, 44, 30, 85, 53, 9, 70, 25, 63, 47, 4, 81, 14, 66, 36, 7, 41, 18, 71, 22, 57, 35, 89, 26, 54, 13, 48, 31, 74, 20, 69, 52, 16, 79, 33, 88, 24, 58, 46, 28, 65, 51, 39, 86, 43};
        A = quickSort(A, 0, A.length-1);
        for(int i : A){
            System.out.println(i);
        }
    }

    public static int[] quickSort(int[] A, int p, int r){
        if(p < r){
            int s = lomutoPartition(A, p, r);
            A = quickSort(A, p, s-1);
            A = quickSort(A, s+1, r);
        }
        return A;
    }
    
    private static int lomutoPartition(int[] A, int p, int r){
        int pivot = A[r];
        int i = p-1;
    
        for(int j = p; j < r; j++){
            if(A[j] <= pivot){
                i = i+1;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        int temp = A[i+1];
        A[i+1] = A[r];
        A[r] = temp;
        return i+1;
    }
    
}
