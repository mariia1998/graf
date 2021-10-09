package m1graf2021;

import java.util.*;

public class Graf {

    protected Map<Node, List<Edge>> adjEdList;
    protected List<Edge> edgeList;
    private List<Node> nodes;


    public Graf() {
        adjEdList = new TreeMap<>();
        this.edgeList = new ArrayList<>();
    }

    public Graf(Map<Node, List<Edge>> adjEdList, List<Edge> edgeList) {
        this.adjEdList = adjEdList;
        this.edgeList = edgeList;
    }

    /***
     * Method that return the number of node in graph
     * @return the number of node in graph
     */
    public int nbNodes() {
        return this.nodes.size();
    }


    public boolean existsNode(Node n) {
        if (adjEdList.containsKey(n)) {
            return true;
        }
        return false;
    }

    public void addNode(Node node) {
        if(node == null) {
            return;
        }
        if(existsNode(node)) {
            return;
        }
         nodes.add(node);
    }


    public void addEdge(Node from, Node to) {
        if(from == null || to == null) {
            return;
        }

        if(existsNode(from) && existsNode(to)) {
            return;
        }
        nodes.add(from);
        nodes.add(to);

    }

    public void addEdge(int from, int to, Edge edge) {
        Node fromNode = new Node(from);
        addNode(fromNode);
        addNode(to);
        this.edgeList.add(edge);

        this.adjEdList.put(fromNode , this.edgeList);
    }

    public void addNode(int id) {
        addNode(new Node(id));
    }

 /*   public List<Node> getAllNodes(){

    }*/
}