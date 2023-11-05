package Praktikum1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class QuickSortMedian3 {
    public static void main(String[] args){
        int[] smallest = readFile("Praktikum1/Unsorted_100000.txt");
        int[] medium = readFile("Praktikum1/Unsorted_1000000.txt");
        int[] big = readFile("Praktikum1/Unsorted_5000000.txt");
        int[] preSorted = readFile("Praktikum1/Sorted_100000.txt");

        long startSmallest = System.currentTimeMillis();
        int[] sortedSmallest = quickSort(smallest, 0, smallest.length-1);
        long endSmallest = System.currentTimeMillis();

        long startMedium = System.currentTimeMillis();
        int[] sortedMedium = quickSort(medium, 0, medium.length-1);
        long endMedium = System.currentTimeMillis();

        long startBig = System.currentTimeMillis();
        int[] sortedBig = quickSort(big, 0, big.length-1);
        long endBig = System.currentTimeMillis();

        long startSorted = System.currentTimeMillis();
        preSorted = quickSort(preSorted, 0, preSorted.length-1);
        long endSorted = System.currentTimeMillis();

        long timeSmallest = endSmallest - startSmallest;
        long timeMedium = endMedium - startMedium;
        long timeBig = endBig - startBig;
        long timeSorted = endSorted - startSorted;

        //https://docs.oracle.com/javase/8/docs/api/java/io/FileWriter.html
        try(FileWriter file = new FileWriter("Praktikum1/results.txt", true)){
            file.write("MedianOfThree:\n");
            file.write("Small: "+ timeSmallest + "\n");
            file.write("Medium: "+ timeMedium + "\n");
            file.write("Big: "+ timeBig + "\n");
            file.write("Sorted " + timeSorted + "\n");
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    //basierend auf "Folien_4_Suchen_Sortieren" Seite 13
    public static int[] quickSort(int[] A, int p, int r) {
        if (p < r) {
            int s = lomutoPartition(A, p, r);
            quickSort(A, p, s - 1);
            quickSort(A, s + 1, r);
        }
        return A;
    }

    private static int medianOfThree(int[] A, int p, int r) {
        int mid = (r + p) / 2;

        if (A[p]>A[mid]){
           tausche(A, p, mid);
        }
        if(A[p]>A[r]){
            tausche(A,p,r);
        }
        if(A[mid]>A[r]){
            tausche(A, mid, r);
        }

        return mid;
    }

    private static int lomutoPartition(int[] A, int p, int r) {
        int pivotIndex = medianOfThree(A, p, r);
        tausche(A, pivotIndex, r);
        int pivot = A[r];

        int i = p-1;

        for(int j = p; j < r; j++){
            if(A[j] <= pivot){
                i = i+1;
                tausche(A, i, j);
            }
        }
        tausche(A, i + 1, r);
        return i+1;
    }

    private static void tausche(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //https://www.geeksforgeeks.org/read-file-into-an-array-in-java/
    public static int[] readFile(String fileName){
        ArrayList<Integer> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line = reader.readLine()) != null){
                int i = Integer.parseInt(line);
                list.add(i);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        int[] arr = new int[list.size()];
        for(int i = 0; i<list.size(); i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}
