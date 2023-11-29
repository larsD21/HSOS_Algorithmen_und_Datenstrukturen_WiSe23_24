package Praktikum5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class DirectedGraph {
    public static final double INFINITY = Double.MAX_VALUE;
    private Map<String,Node> nodes =  new HashMap<String,Node>();
    public static DirectedGraph readGraph(String file) {
        DirectedGraph directedGraph = new DirectedGraph();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line = bufferedReader.readLine();
            while(line != null){
                String[] values = line.split(" ");
                directedGraph.addNode(values[0]);
                directedGraph.addNode(values[1]);
                directedGraph.addEdge(values[0], values[1], Double.parseDouble(values[2]));
                line = bufferedReader.readLine();
            }
        } catch (IOException exception){
            return null;
        }
        return directedGraph;
    }

    private void addNode(String n){
        if(!nodes.containsKey(n)){
            nodes.put(n, new Node(n));
        }
    }

    private void addEdge(String origin, String dest, double w){
        //nodes.get(origin).neighbors.add(new Edge(nodes.get(dest), w));
        Node originNode = nodes.get(origin);
        Node destNode = nodes.get(dest);

        originNode.neighbors.add(new Edge(destNode, w));
    }
    public boolean BFS(String start, String dest, int max) {
        /**
         * Die Methode BFS() sucht einen Pfad vom angegebenen Startknoten start
         * zum Zielknoten dest, der über maximal max Kanten führt. Existiert ein solcher
         * Pfad ist der Return-Wert true, ansonsten false.
         */
        for(Node u : nodes.values()){
            u.prev = null;
            u.dist = INFINITY;
            u.visited = false;
        }

        Node s = nodes.get(start);
        if(s == null){
            return false;
        }
        Node d = nodes.get(dest);
        if (d == null){
            return false;
        }

        s.prev = null;
        s.dist = 0;
        s.visited = true;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(s);

        while (!queue.isEmpty()){
            Node u = queue.poll();
            if(u.dist == max){
                return u.equals(d);
            }
            for(Edge e : u.neighbors){
                Node v = e.dest;

                if(!v.visited){
                    v.visited = true;
                    v.dist = u.dist +1;
                    v.prev = u;
                    queue.add(v);
                }
            }
        }
        return true;
    }

    public void printPath(String dest) {
        /**
         * Die Methode printPath() gibt den vorher ermittelten Pfad durch
         * Rückverfolgung aus.
         */
        Node d = nodes.get(dest);
        if(d == null){
            return;
        }

        Node current = d;

        while(current != null){
            System.out.print(current.name);
            current = current.prev;
            if(current != null){
                System.out.print(" <- ");
            }
        }
    }
}
