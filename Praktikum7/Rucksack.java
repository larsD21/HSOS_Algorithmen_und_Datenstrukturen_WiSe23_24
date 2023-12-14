package Praktikum7;

import java.util.ArrayList;

//8806
public class Rucksack {
    public static ArrayList<Integer> rucksack(int g, int n, int[] a, int[] w) {
        int[][] W = new int[n + 1][g + 1];
        int[][] R = new int[n + 1][g + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= g; j++) {
                if (i == 0 || j == 0) {
                    W[i][j] = 0;
                    R[i][j] = 0;
                } else if (a[i - 1] <= j && W[i - 1][j - a[i - 1]] + w[i - 1] > W[i - 1][j]) {
                    W[i][j] = W[i - 1][j - a[i - 1]] + w[i - 1];
                    R[i][j] = i;
                } else {
                    W[i][j] = W[i - 1][j];
                    R[i][j] = R[i - 1][j];
                }
            }
        }


        //System.out.println(W[n][g]);
        // Zurückverfolgung der ausgewählten Elemente im Rucksack
        ArrayList<Integer> selectedItems = new ArrayList<>();
        int i = n, j = g;
        while (i > 0 && j > 0) {
            if (R[i][j] != R[i - 1][j]) {
                selectedItems.add(i - 1); // Index des ausgewählten Elements
                j -= a[i - 1];
            }
            i--;
        }
        return selectedItems;
    }
}
