package Praktikum7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Rucksack {
    public static ArrayList<Integer> rucksack(int g, int n, int[] a, int[] w) {

        return null;
    }

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
                wList.add(Integer.parseInt(values[2]));
                line = reader.readLine();
            }
            n = wList.size();
            int[] w = new int[wList.size()];
            int[] a = new int[aList.size()];

            for(int i = 0; i< wList.size(); i++){
                w[i] = wList.get(i);
            }

            for(int i = 0; i< aList.size(); i++){
                a[i] = aList.get(i);
            }

            ArrayList<Integer> result = rucksack(g, n, a, w);
        } catch (IOException e){

        }


    }
}