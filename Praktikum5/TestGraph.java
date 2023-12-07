package Praktikum5;

public class TestGraph {
    public static void main(String[] args){
        String path = "Praktikum5/OS_Map.txt";

        DirectedGraph directedGraph = DirectedGraph.readGraph(path);

        if(directedGraph.BFS("Bissendorf", "Wallenhorst", 5)){
            directedGraph.printPath("Wallenhorst");
        } else{
            System.out.println("Dest not in range of max");
        }

    }
}
