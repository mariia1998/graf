package m1graf2021;

import java.util.List;
import java.util.Map;

public class UndirectedGraf extends Graf{

    public UndirectedGraf(Map<Node, List<Edge>> adjEdList, List<Edge> edgeList) {
        super(adjEdList, edgeList);
    }
}
