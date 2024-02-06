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
            ArrayList<Integer> krach = new ArrayList<>();
            int cnt = 1;
            while (line != null) {
                String[] values = line.trim().split("\\s+");
                krach.add(Integer.parseInt(values[2]) * Integer.parseInt(values[1]));
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
            int[] a = new int[aList.size()+1];
            int[] w = new int[wList.size()+1];

            for (int i = 1; i<n; i++){
                a[i] = aList.get(i);
                w[i] = wList.get(i);
            }

            int[] anzahl = new int[id.get(id.size()-1)];
            ArrayList<Integer> result = Rucksack.rucksack(g, n, a, w);
            System.out.println(result.toString());
            System.out.println(result.size());

            int gesPreis = 0;

            for(Integer i : result){
                int iID = id.get(i);
                gesPreis += a[i];
                anzahl[iID-1]++;
            }

            int gesKrach = 0;
            for(int i = 0; i<anzahl.length; i++){
                if (anzahl[i]>0) {
                    System.out.println((i+1) + " : " + anzahl[i]);
                    gesKrach += anzahl[i]*krach.get(i);
                }

            }

            System.out.println("Gesamter Krach: " + gesKrach);
            System.out.println("Gesamtpreis: " + gesPreis);
        } catch (IOException e){
            System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
        }
    }
}


