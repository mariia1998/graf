package m1graf2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Graf  {

    protected Map<Node, List<Edge>> adjEdList;
    protected List<Edge> edgeList = new ArrayList<>();

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
        return adjEdList.size();
    }

}
