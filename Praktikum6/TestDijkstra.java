package Praktikum6;

public class TestDijkstra {
    public static void main(String[] args){
        DirectedGraph directedGraph = DirectedGraph.readGraph("Praktikum6/OS_Map.txt");

        directedGraph.dijkstra("Bad_Essen");
        directedGraph.printPath("Glandorf");
    }
}
