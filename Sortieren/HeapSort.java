package Sortieren;

public class HeapSort {
    public static void main(String[] args){
        int[] A = {12, 56, 32, 87, 45, 3, 67, 91, 34, 29, 76, 23, 8, 59, 40, 15, 68, 72, 19, 5, 42, 10, 61, 27, 50, 2, 95, 49, 11, 73, 37, 80, 17, 64, 21, 55, 38, 6, 78, 1, 44, 30, 85, 53, 9, 70, 25, 63, 47, 4, 81, 14, 66, 36, 7, 41, 18, 71, 22, 57, 35, 89, 26, 54, 13, 48, 31, 74, 20, 69, 52, 16, 79, 33, 88, 24, 58, 46, 28, 65, 51, 39, 86, 43};
        A = heapSort(A);
        for(int i : A){
            System.out.println(i);
        }
    }

    public static int[] heapSort(int[] A){
        A = buildMaxHeap(A);
        for(int i = A.length - 1; i > 0; i--){
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            maxHeapify(A, 0, i);
        }
        
        return A;
    }
    
    private static int[] buildMaxHeap(int[] A){
        int n = A.length;
        for(int i = n/2 - 1; i >= 0; i--){
            A = maxHeapify(A, i, n);
        }
        return A;
    }
    
    private static int[] maxHeapify(int[] A, int i, int n){
        int l = left(i);
        int r = right(i);
        int largest = i;
        if(l < n && A[l] > A[i]){
            largest = l;
        }
        if(r < n && A[r] > A[largest]){
            largest = r;
        }
        if(largest != i){
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            A = maxHeapify(A, largest, n);
        }
        return A;
    }
    
    private static int left(int i){
        return 2 * i + 1;
    }
    
    private static int right(int i){
        return 2 * i + 2;
    }
    

    private static int parent(int i){
        return i/2;
    }
}
