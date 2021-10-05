package m1graf2021;

import java.util.Objects;

public class Edge implements Comparable<Edge>  {


    private int to ;
    private int from;
    private int weight ;

    private Node fromNode;
    private Node toNode;
    private String label;






    /*
     * Constructor of one edge
     * @param from the node from of one edge
     * @param to the node to of one edge
     */
    public Edge(int from,int to){
        this.from = from;
        this.to = to;
    }


    public Edge(int from,int to, int weight){
        this(from, to);
        this.weight= weight;
    }

    public Edge(int from,int to,int weight, String label){
        this(from,to,weight);
        this.label = label;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    /**
     * Constructor of the edge
     * @param from the starting point node
     * @param to the end point node
     */
    public Edge(Node from, Node to) {
        this.fromNode = from;
        this.toNode = to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public int getFrom() {
        return from;
    }


    public String toString() {
        return  "("+ from + ") -> " + "(" + to + ")";
    }

    @Override
    public int compareTo(Edge o) {
        return from - o.getFrom();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return to == edge.to && from == edge.from && weight == edge.weight && Objects.equals(fromNode, edge.fromNode) && Objects.equals(toNode, edge.toNode) && Objects.equals(label, edge.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(to, from, weight, fromNode, toNode, label);
    }
}
