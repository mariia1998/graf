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

    /**
     * Ellipsis constructor
     * @param nodes integer nodes
     */
    public Graf(int...nodes) {
        this.nodes = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();
        this.adjEdList = new TreeMap<>();

        int nodeOrderNumber = 1;
        for(int i = 0; i < nodes.length; i++) {
            this.nodes.add(new Node(nodes[i]));
            if(nodes[i] != 0) {
                edges.add(new Edge(nodeOrderNumber, nodes[i]));
            }
            else {
                if(i != 0 && nodes[i-1] == 0) {
                    edges.add(new Edge(nodeOrderNumber, 0)); //Associating edgeless to 0 instead of null
                }
               adjEdList.put(new Node(nodeOrderNumber),edges);
               nodeOrderNumber++;
               edges = new ArrayList<>(); //Resetting the edges
           }
        }

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


    public void addEdge(int from, int to) {
        addEdge(new Node(from), new Node(to));
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



    public int[] toSuccessorArray() {
        final int NODE_SIZE = this.nodes.size();
        int[] nodes = new int[NODE_SIZE];

        int i = 0;
        for (Node node : this.nodes) {
            nodes[i++] = node.getId();
        }
        return nodes;
    }


    private int getLineMatNumber() {
        int lineNumber = 0;
        for(int i = 0; i < this.nodes.size(); i++) {
            if(this.nodes.get(i).getId() == 0) {
                lineNumber++;
            }
        }
        return lineNumber;
    }

    public int[][] toAdjMatrix() {
        final int ADJ_SIZE = getLineMatNumber(); //Size of the column that we want to put into the adjMatrix

        int adjMatrix[][] = new int[ADJ_SIZE][ADJ_SIZE];
        int line = 0;
        int sucArr [] = toSuccessorArray();

        for(int i = 0; i < sucArr.length; i++) {
           if(sucArr[i] == 0) {
               line++;
           }
           else {
               adjMatrix[line][sucArr[i]-1] = 1;
           }

        }
        return adjMatrix;
    }




    public String toDotString() {
        String dotString = "diagraph {\n";


        for (Node key: this.adjEdList.keySet()) {
            List<Edge> edges = adjEdList.get(key);
            dotString += "\t"+key;
            boolean displayArrow = true;
            for(int i = 0; i < edges.size(); i++) {
                Edge edge = edges.get(i);
                if(edge.getTo() == 0) {
                    continue;
                }
                if(displayArrow) {
                    dotString += " -> ";
                    displayArrow = false;
                }
                dotString += edge.getTo();
                if(i < edges.size() - 1) {
                    dotString += ", ";
                }
            }

            dotString += ";\n";
        }

        return dotString+"}";
    }

    public int nbEdges() {
        return 0;
    }


 /*   public List<Node> getAllNodes(){

    }*/
}