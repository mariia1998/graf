package m1graf2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Graf {

    protected Map<Node, List<Node>> adjEdList;
    protected List<Edge> edgeList = new ArrayList<>();

    public Graf() {
        adjEdList = new TreeMap<>();
        this.edgeList = new ArrayList<>();
    }

    public Graf(Map<Node, List<Node>> adjEdList, List<Edge> edgeList) {
        this.adjEdList = adjEdList;
        this.edgeList = edgeList;
    }

    /***
     * Method that return the number of node in graph
     * @return the number of node in graph
     */
    public int nbNodes() {
        return adjEdList.size();
    }


    public boolean existsNode(Node n) {
        if (adjEdList.containsKey(n)) {
            return true;
        }
        return false;
    }

    public void addNode(Node n) {
        if (existsNode(n)) {
            System.out.println("the node already exists");
        }
        else
        {
            List<Node> added =new ArrayList<>();
            adjEdList.put(n, added);}

    }

    public void addNode(int id) {
        Node node = new Node(id);
        addNode(node);
    }

 /*   public List<Node> getAllNodes(){

    }*/
}