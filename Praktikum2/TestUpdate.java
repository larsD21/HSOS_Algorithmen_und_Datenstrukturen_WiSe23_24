package Praktikum2;

import java.util.Random;

public class TestUpdate {
    public static void main(String[] args){
        MinPQ testQueue = new MinPQ(1000);

        Random random = new Random();

        for(int i = 1; i<=1000; i++){
            testQueue.insert(Integer.toString(i),random.nextInt(10000));
        }

        for(int i = 1; i<=1000; i=i+2){
            testQueue.update(Integer.toString(i), random.nextInt(10000));
        }

        while(!testQueue.isEmpty()){
            System.out.println(testQueue.extractElement().getPriority());
        }
    }
}
