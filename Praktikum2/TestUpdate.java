package Praktikum2;

import java.util.Random;

public class TestUpdate {
    public static void main(String[] args){
        MinPQ testQueue = new MinPQ(1000);

        Random random = new Random();

        for(int i = 1; i<=1000; i++){
            testQueue.insert( Integer.toString(i),random.nextInt(10000));
        }

        for(int i = 1; i<=1000; i++){
            if(i % 2 == 0){
                testQueue.update(Integer.toString(i), random.nextInt(10000));
            }
        }
    }
}
