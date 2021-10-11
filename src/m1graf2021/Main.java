package m1graf2021;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Main {


    public static void main(String[] args) {

        Graf graf = new Graf();

        System.out.println(">>>>>>>> Creating the subject example graph in G");
        Graf g = new Graf(2, 4, 0, 0, 6, 0, 2, 3, 5, 8, 0, 0, 4, 7, 0, 3, 0, 7, 0);
        System.out.println(">>>> Graph information");
        System.out.println(">> DOT representation\n"+g.toDotString());
        System.out.println(""+g.nbNodes()+" nodes, "+g.nbEdges()+" edges");
        System.out.println(">> Nodes: ");
        Node n1 = new Node(1,"Test");
        Node n2 = new Node(2,"Test2");
        Node n3 = new Node(3,"Test3");
        System.out.println(n1.toString());
// 1  (1,2)
        Edge e1 = new Edge(n1,n2);
        Edge e2 = new Edge(n1,n3);
        System.out.println(e1.toString());

        Map<Node, ArrayList<Edge>> adjEdList = new TreeMap<>();

        ArrayList l = new ArrayList();
        l.add(e1);
        l.add(e2);
        adjEdList.put(n1,l);

        Graf graff = new Graf(adjEdList);

        System.out.println(graff.toString());

    }
}
