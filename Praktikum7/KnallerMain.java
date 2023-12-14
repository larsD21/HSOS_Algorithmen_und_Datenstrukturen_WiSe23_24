package Praktikum7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class KnallerMain {
    public static void main(String[] args){
        try (BufferedReader reader = new BufferedReader(new FileReader("Praktikum7/knaller.dat"))) {
            String line = reader.readLine();
            ArrayList<Integer> aList = new ArrayList<>();
            ArrayList<Integer> wList = new ArrayList<>();
            ArrayList<Integer> id = new ArrayList<>();
            int cnt = 1;
            while (line != null) {
                String[] values = line.split("\\s+");

                for(int i = 0; i<Integer.parseInt(values[0]); i++){
                    aList.add(Integer.parseInt(values[3]));
                    wList.add(Integer.parseInt(values[2]) * Integer.parseInt(values[1]));
                    id.add(cnt);
                }
                cnt++;
                line = reader.readLine();
            }

            int n = aList.size();
            int g = 1000;
            int[] a = new int[aList.size()];
            int[] w = new int[wList.size()];

            for (int i = 0; i<n; i++){
                a[i] = aList.get(i);
                w[i] = wList.get(i);
            }

            System.out.println(id.toString());
            int[] anzahl = new int[id.size()];
            ArrayList<Integer> result = Rucksack.rucksack(g, n, a, w);
            //System.out.println(a.length);
            for(int i = 0; i<result.size(); i++){
                anzahl[i] += result.get(i);
            }

            for(Integer i : anzahl){
                System.out.println(i+1 + " : " + i + " mal");
            }

        } catch (IOException e){
            System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
        }
    }
}


