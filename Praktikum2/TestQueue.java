package Praktikum2;

import java.util.Random;

public class TestQueue {
    public static void main(String[] args){
        MinPQ testQueue = new MinPQ(1000);

        Random random = new Random();

        for(int i = 0; i<1000; i++){
           testQueue.insert( " ",random.nextInt(10000));
        }

        while (!testQueue.isEmpty()){
            System.out.println(testQueue.extractElement().getPriority());
        }
    }
}
