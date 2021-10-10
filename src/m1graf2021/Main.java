package m1graf2021;

import java.util.*;

public class Main {


    public static void main(String[] args) {

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

        Graf graf = new Graf(adjEdList);

        System.out.println(graf.toString());


    }
}
