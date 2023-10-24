package Praktikum1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class QuickSortMedian3 {
    public static void main(String[] args){
        int[] smallest = readFile("Praktikum1/100000.txt");
        int[] medium = readFile("Praktikum1/1000000.txt");
        int[] big = readFile("Praktikum1/5000000.txt");

        long startSmallest = System.currentTimeMillis();
        int[] sortedSmallest = quickSort(smallest, 0, smallest.length-1);
        long endSmallest = System.currentTimeMillis();

        long startMedium = System.currentTimeMillis();
        int[] sortedMedium = quickSort(medium, 0, medium.length-1);
        long endMedium = System.currentTimeMillis();

        long startBig = System.currentTimeMillis();
        int[] sortedBig = quickSort(big, 0, big.length-1);
        long endBig = System.currentTimeMillis();



        int[] preSorted = new int[100000];
            for(int i = 0; i < preSorted.length; i++){
            preSorted[i] = i;
        }

        long startSorted = System.currentTimeMillis();
        preSorted = quickSort(preSorted, 0, preSorted.length-1);
        long endSorted = System.currentTimeMillis();

        for(Integer i : sortedSmallest){
            System.out.println(i);
        }

        long timeSmallest = endSmallest - startSmallest;
        long timeMedium = endMedium - startMedium;
        long timeBig = endBig - startBig;
        long timeSorted = endSorted - startSorted;
        System.out.println("Small: "+ timeSmallest);
        System.out.println("Medium: "+ timeMedium);
        System.out.println("Big: "+ timeBig);
        System.out.println("Sorted " + timeSorted);

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


    public static int[] quickSort(int[] A, int p, int r) {
        if (p < r) {
            int pivotIndex = medianOfThree(A, p, r);
            int s = lomutoPartition(A, p, r, pivotIndex);
            quickSort(A, p, s - 1);
            quickSort(A, s + 1, r);
        }
        return A;
    }

    private static int medianOfThree(int[] A, int p, int r) {
        int m = p + (r - p) / 2;
        int[] arr = {p, m, r};

        if(A[arr[0]] > A[arr[1]]){
            int temp = arr[0];
            arr[0] = arr[1];
            arr[1] = temp;
        }

        if(A[arr[0]] > A[arr[2]]){
            int temp = arr[0];
            arr[0] = arr[2];
            arr[2] = temp;
        }

        if(A[arr[1]]>A[arr[2]]){
            int temp = arr[2];
            arr[2] = arr[1];
            arr[1] = temp;
        }

        return arr[1];
    }

    private static int lomutoPartition(int[] A, int p, int r, int pivotIndex) {
        int pivot = A[pivotIndex];
        A[pivotIndex] = A[r];
        A[r] = pivot;

        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (A[j] <= pivot) {
                i = i + 1;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        int temp = A[i + 1];
        A[i + 1] = A[r];
        A[r] = temp;
        return i + 1;
    }

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
