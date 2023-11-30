package Praktikum7;

import java.util.ArrayList;

public class Rucksack {
    public static ArrayList<Integer> rucksack(int g, int n, int[] a, int[] w) {
        int[][] R = new int[n + 1][g + 1];
        int[][] W = new int[n + 1][g + 1];

        for (int i = 0; i <= g; i++) {
            W[0][i] = 0;
            R[0][i] = -1; // Æ wurde durch -1 ersetzt, um ein leeres Element darzustellen
        }

        for (int k = 1; k <= n; k++) {
            for (int j = 0; j <= g; j++) {
                if (a[k] <= j && W[k - 1][j - a[k]] + w[k] > W[k - 1][j]) {
                    R[k][j] = k;
                    W[k][j] = W[k - 1][j - a[k]] + w[k];
                } else {
                    R[k][j] = R[k - 1][j];
                    W[k][j] = W[k - 1][j];
                }
            }
        }

        // Zurückverfolgung der ausgewählten Gegenstände und ihrer Anzahl
        ArrayList<Integer> selectedItems = new ArrayList<>();
        int remainingCapacity = g;
        for (int i = n; i > 0 && remainingCapacity > 0; i--) {
            if (R[i][remainingCapacity] != R[i - 1][remainingCapacity]) {
                int count = 0;
                while (i > 0 && R[i][remainingCapacity] == i) {
                    count++;
                    remainingCapacity -= a[i];
                    i--;
                }
                selectedItems.add(count);
                i++;
            }
        }

        return selectedItems;
    }
}
