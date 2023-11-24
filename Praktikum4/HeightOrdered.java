package Praktikum4;

import java.io.FileWriter;
import java.io.IOException;

public class HeightOrdered {
    public static void main(String[] args){
        RedBlackTree redBlackTree = new RedBlackTree();

        for (int i = 0; i<10000; i++){
            redBlackTree.insert(i, Integer.toString(i));
        }

        int height = redBlackTree.height();

        try(FileWriter file = new FileWriter("Praktikum4/results.txt")){
            file.write(Integer.toString(height));
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
