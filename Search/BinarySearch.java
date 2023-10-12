package Search;

public class BinarySearch {
    public static void main(String[] args){
        
        int[] A = {1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 61, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 76, 78, 79, 80, 81, 85, 86, 87, 88, 89, 91, 95};
        System.out.println(binarySearch(A, 66));
        
    }

    private static int binarySearch(int[] A, int key){
        int l = 0;
        int r = A.length-1;
        while(l <= r){
            int m = (l+r)/2;
            if(key < A[m]){
                r = m-1;
            }else if(key > A[m]){
                l = m+1;
            }else{
                return m;
            }
        }
        return -1;
    }
}
