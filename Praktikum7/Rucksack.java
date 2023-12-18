package Praktikum7;

import java.util.ArrayList;

//8806
public class Rucksack {
    public static ArrayList<Integer> rucksack(int g, int n, int[] a, int[] w) {
        int[][] W = new int[n + 1][g + 1];

        for (int i = 0; i <= n; i++) {
            W[i][0] = 0;
        }

        for (int k = 1; k <= n; k++) {
            for (int j = 0; j <= g; j++) {
                if (a[k] <= j && W[k - 1][j - a[k]] + w[k] > W[k - 1][j]) {
                    W[k][j] = W[k - 1][j - a[k]] + w[k];
                } else {
                    W[k][j] = W[k - 1][j];
                }
            }
        }

        System.out.println(W[n][g]);

        ArrayList<Integer> solution = new ArrayList<>();
        int i = n;
        int j = g;
        while (i > 0 && j > 0) {
            if (W[i][j] == W[i - 1][j]) {
                i--;
            } else {
                solution.add(i);
                j -= a[i];
                i--;
            }
        }

        return solution;
    }
}
