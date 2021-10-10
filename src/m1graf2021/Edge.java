package m1graf2021;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Edge implements Comparable<Edge>  {


    private int to ;
    private int from;
    private int weight ;

    private Node fromNode;
    private Node toNode;
    private String label;


    /*
     * Constructor of one edge,  2 nodes(type Node instead of Integer)
     * @param from the node from of one edge
     * @param to the node to of one edge
     */
    public Edge(Node from, Node to) {
        if(from == null || to == null) {
            throw new NullPointerException("Null arguments");
        }
        this.fromNode = from;
        this.toNode = to;
    }




    /*
     * Constructor of one edge, 2 nodes(type Integer instead of Node)
     * @param from the node from of one edge
     * @param to the node to of one edge
     */
    public Edge(int from,int to){
        this(new Node(from), new Node(to));
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


    public void setTo(int to) {
        this.to = to;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return this.to;
    }

    public int getFrom() {
        return this.from;
    }


    public String toString() {
        return  "("+ from + ") -> " + "(" + to + ")";
    }

    //The edges are ordered first by source node number,
    //then by target node number in case of source node equality
    @Override
    public int compareTo(@NotNull Edge o) {
        int result = this.from - o.from;
        if(result == 0) {
            result = this.to - o.to;
        }
        return result;
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
