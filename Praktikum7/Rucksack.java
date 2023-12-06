package Praktikum7;

import java.util.ArrayList;
import java.util.Collections;

public class Rucksack {
    public static ArrayList<Integer> rucksack(int g, int n, int[] a, int[] w) {
        int[][] R = new int[n + 1][g + 1];
        int[][] W = new int[n + 1][g + 1];

        for (int i = 0; i <= g; i++) {
            W[0][i] = 0;
            R[0][i] = -1;
        }

        for (int k = 1; k <= n; k++) {
            for (int j = 0; j <= g; j++) {
                if (a[k - 1] <= j && W[k - 1][j - a[k - 1]] + w[k - 1] > W[k - 1][j]) {
                    R[k][j] = k - 1;
                    W[k][j] = W[k - 1][j - a[k - 1]] + w[k - 1];
                } else {
                    R[k][j] = k - 1;
                    W[k][j] = W[k - 1][j];
                }
            }
        }

        ArrayList<Integer> quantities = new ArrayList<>();
        int k = n;
        int j = g;

        while (k > 0 && j > 0) {
            if (R[k][j] != R[k - 1][j]) {
                int count = 0;
                int tempK = k;

                while (tempK > 0 && R[tempK][j] == R[tempK - 1][j]) {
                    tempK--;
                }

                while (k >= tempK && j >= 0 && R[k][j] != R[k - 1][j]) {
                    count++;
                    j -= a[k - 1];
                }

                quantities.add(count);
            }
            k--;
        }
        return quantities;

    }
}
