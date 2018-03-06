import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/***
 * This class implements a graph composed by an array of edges, witch is ordered by cost when the graph
 * is created (they last level edges are not ordered). This graph can´t be modified.
 */
public class Graph {

    private List<Edge> edges;
    private int numberOfStages;
    private Node root;

    Graph(Edge[] edges, Node root, Node goal) {
        this.numberOfStages = goal.getStage()+1;
        this.root = root;
        this.edges = new ArrayList<>(Arrays.asList(edges));
        this.edges.sort((edge1, edge2) -> (edge1.getCost() < edge2.getCost()) ? -1 : 1);
    }

    List<Edge> getEdges() {
        return edges;
    }

    int getNumberOfStages() {
        return numberOfStages;
    }

    Node getRoot() {
        return root;
    }

    @Override
    public String toString (){
        StringBuilder string = new StringBuilder();
        for (Edge edge: edges) {
            string.append(edge.toString()).append("\n");
        }
        return string.toString();
    }

}