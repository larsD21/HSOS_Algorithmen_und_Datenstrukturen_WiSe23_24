package Praktikum5;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public String name;
    public List<Edge> neighbors;
    boolean visited;
    Node prev;
    double dist;
    public Node(String n) {
        this.name = n;
        this.neighbors = new ArrayList<>();
        this.visited = false;
        this.prev = null;
        this.dist = Double.MAX_VALUE;
    }
}
