package m1graf2021;

public class Edge implements Comparable<Edge>  {


    private int to ;
    private int from;



    /*
     * Constructor of one edge
     * @param from the node from of one edge
     * @param to the node to of one edge
     */
    public Edge(int from,int to){
        this.from = from;
        this.to = to;
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
        return 0;
    }
}
