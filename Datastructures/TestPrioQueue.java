package Datastructures;

public class TestPrioQueue {
    public static void main(String[] args){
        PriorityQueue prio = new PriorityQueue(3);
        try {
            prio.insertNew(2);
            prio.insertNew(7);
            prio.insertNew(1);
            prio.insertNew(9);
            prio.insertNew(3);
        } catch (Exception e) {
           System.err.println("heap overflow");
        }

        try {
            System.out.println(prio.extractMax());
            System.out.println(prio.extractMax());
            System.out.println(prio.extractMax());
            prio.insertNew(9);
            System.out.println(prio.extractMax());
        } catch (Exception e) {
            System.err.println("heap underflow");
        }
        
        
    }
}
