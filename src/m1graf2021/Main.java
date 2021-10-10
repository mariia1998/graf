package m1graf2021;

public class Main {


    public static void main(String[] args) {

        Graf graf = new Graf();

        System.out.println(">>>>>>>> Creating the subject example graph in G");
        Graf g = new Graf(2, 4, 0, 0, 6, 0, 2, 3, 5, 8, 0, 0, 4, 7, 0, 3, 0, 7, 0);
        System.out.println(">>>> Graph information");
        System.out.println(">> DOT representation\n"+g.toDotString());
        System.out.println(""+g.nbNodes()+" nodes, "+g.nbEdges()+" edges");
        System.out.println(">> Nodes: ");




    }
}
