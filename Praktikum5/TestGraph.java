package Praktikum5;

public class TestGraph {
    public static void main(String[] args){
        String path = "Praktikum5/OS_Map.txt";

        DirectedGraph directedGraph = DirectedGraph.readGraph(path);

        System.out.println(directedGraph.BFS("Ibbenbueren", "Melle", 2));
        directedGraph.printPath("Bad_Essen");

    }
}
