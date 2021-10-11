package m1graf2021;

import java.util.*;

public class Graf {

    protected Map<Node, List<Edge>> adjEdList;
    protected List<Edge> edgeList;
    private List<Node> nodes;


    private List<Integer> successorArray;


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
        this.edgeList = new ArrayList<>();
        this.adjEdList = new TreeMap<>();
        this.successorArray = new ArrayList<>();

        int nodeOrderNumber = 1;
        for(int i = 0; i < nodes.length; i++) {
            successorArray.add(nodes[i]);
            if(nodes[i] != 0) {
                Edge edge = new Edge(nodeOrderNumber, nodes[i]);
                edges.add(edge);
                edgeList.add(edge);
            }
            else {
                if(i != 0 && nodes[i-1] == 0) {
                    edges.add(new Edge(nodeOrderNumber, 0)); //Associating edgeless to 0 instead of null
                }
                this.nodes.add(new Node(nodeOrderNumber));
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
        for(int i = 0; i < this.successorArray.size(); i++) {
            if(this.successorArray.get(i) == 0) {
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
        return this.edgeList.size();
    }


    public List<Node> getAllNodes(){
        return this.nodes;
    }

    //Knowing the number of node pointed to Node n
    public int inDegree(Node n) {
        int degree = 0;
        for (Edge edge : edgeList) {
            if(n.getId() == edge.getTo()) {
                degree++;
            }
        }
        return degree;
    }

    //Knowing the number of node pointed by Node n
    public int outDegree(Node n) {
        int degree = 0;
        for (Edge edge : edgeList) {
            if(n.getId() == edge.getFrom()) {
                degree++;
            }
        }
        return degree;
    }


    public int degree(Node n) {

        return 0;
    }
}