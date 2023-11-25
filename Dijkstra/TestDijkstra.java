package Dijkstra;

public class TestDijkstra {
    public static void main(String[] args){
        DirectedGraph directedGraph = DirectedGraph.readGraph("Dijkstra/OS_Map.txt");

        directedGraph.dijkstraShortestWay("Bad_Essen", "Glandorf");
        directedGraph.printPath("Glandorf");
    }
}
