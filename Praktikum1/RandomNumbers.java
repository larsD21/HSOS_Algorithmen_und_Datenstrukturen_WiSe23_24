package Praktikum1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomNumbers {
    public static void main(String[] args){
        randomNumbers(100000);
        randomNumbers(1000000);
        randomNumbers(5000000);
        sortedNumbers(100000);

    }

    public static void randomNumbers(int cnt){
        Random random = new Random();
        //https://docs.oracle.com/javase/8/docs/api/java/io/FileWriter.html
        try(FileWriter file = new FileWriter("Praktikum1/Unsorted_"+ cnt + ".txt")){
            for(int i = 0; i < cnt; i++) {
                //https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
                int randomNum = random.nextInt(5000001);
                file.write(Integer.toString(randomNum) + "\n");
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void sortedNumbers(int cnt){
        try(FileWriter file = new FileWriter("Praktikum1/Sorted_"+ cnt + ".txt")){
            for(int i = 0; i < cnt; i++) {
                file.write(Integer.toString(i) + "\n");
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

}
