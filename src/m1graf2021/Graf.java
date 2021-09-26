package m1graf2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Graf  {

    Map<Node, List<Edge>> adjEdList;
    List<Edge> EdgeList = new ArrayList<>();

    public Graf() {
        adjEdList = new TreeMap<>();
        this.EdgeList = new ArrayList<>();
    }

    /***
     * Method that return the number of node in graph
     * @return the number of node in graph
     */
    public int nbNodes() {
        return adjEdList.size();
    }

}
