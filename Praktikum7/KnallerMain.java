package Praktikum7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class KnallerMain {
    public static void main(String[] args){
        try(BufferedReader reader = new BufferedReader(new FileReader("Praktikum7/knaller.dat"))){
            String line = reader.readLine();
            int g = 1000;
            int n = 0;
            ArrayList<Integer> aList = new ArrayList<>();
            ArrayList<Integer> wList = new ArrayList<>();
            while(line != null){
                String[] values = line.split("\\s+");
                aList.add(Integer.parseInt(values[3]));
                wList.add(Integer.parseInt(values[2]) * Integer.parseInt(values[1]));
                line = reader.readLine();
            }
            n = wList.size() - 1;
            int[] w = new int[wList.size()];
            int[] a = new int[aList.size()];

            for(int i = 0; i < wList.size(); i++){
                w[i] = wList.get(i);
            }

            for(int i = 0; i < aList.size(); i++){
                a[i] = aList.get(i);
            }

            ArrayList<Integer> result = Rucksack.rucksack(g, n, a, w);

            // Ausgabe der ausgewählten Gegenstände und ihrer Anzahl
            System.out.println(result.toString());
        } catch (IOException e){
            System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
        }
    }
}


