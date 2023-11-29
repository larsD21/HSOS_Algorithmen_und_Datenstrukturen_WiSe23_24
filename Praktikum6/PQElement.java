package Praktikum6;

public class PQElement {
    private String data;
    private double priority;

    public PQElement(String s, double d) {
        this.data = s;
        this.priority = d;
    }

    public String getData(){
        return this.data;
    }

    public double getPriority(){
        return this.priority;
    }

    public void  setPriority(double d){
        this.priority = d;
    }
}
