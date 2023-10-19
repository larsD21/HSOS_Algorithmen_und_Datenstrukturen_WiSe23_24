package Praktikum1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomNumbers {
    public static void main(String[] args){
        randomNumbers(100000);
        randomNumbers(1000000);
        randomNumbers(5000000);
    }

    public static void randomNumbers(int cnt){
        Random random = new Random();
        try(FileWriter file = new FileWriter("Praktikum1/"+ cnt + ".txt")){
            for(int i = 0; i < cnt; i++) {
                int randomNum = random.nextInt(0,5000001);
                file.write(Integer.toString(randomNum) + "\n");
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

}
