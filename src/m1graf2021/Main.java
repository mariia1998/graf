package m1graf2021;

import java.util.Collections;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        Graf graf = new Graf();

        System.out.println(">>>>>>>> Creating the subject example graph in G");
        Graf g = new Graf(2, 4, 0, 0, 6, 0, 2, 3, 5, 8, 0, 0, 4, 7, 0, 3, 0, 7, 0);
        System.out.println(">>>> Graph information");
        System.out.println(">> DOT representation\n"+g.toDotString());
        System.out.println(""+g.nbNodes()+" nodes, "+g.nbEdges()+" edges");
        System.out.println(">> Nodes: ");
        List<Node> nodes = g.getAllNodes();
        Collections.sort(nodes);
        for (Node n: nodes)
            System.out.println("Node "+n+": degree "+g.degree(n)+" (in: "+g.inDegree(n)+"/ out: "+g.outDegree(n)+")");

        List<Edge> edges;
        System.out.println(">> Edges: ");
        System.out.println("---------------------------");
        System.out.println("Out-edges per node");
//        for (Node n: nodes) {
//            edges = g.getOutEdges(n);
//            Collections.sort(edges);
//            System.out.println(""+n+": "+edges);
//        }
//
//        System.out.println("In-edges per node");
//        for (Node n: nodes) {
//            edges = g.getInEdges(n);
//            Collections.sort(edges);
//            System.out.println(""+n+": "+edges);
//        }


    }
}
