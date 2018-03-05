import java.util.ArrayList;
import java.util.Arrays;

/***
 * This class implements a graph composed by an array of edges, witch is ordered by cost when the graph
 * is created (they last level edges are not ordered). This graph can´t be modified.
 */
public class Graph {

    private Edge[] edges;
    private int numberOfNodes;
    private Node root;

    Graph(Edge[] edges, Node root, Node goal) {
        this.numberOfNodes = goal.getStage();
        this.root = root;
        this.edges = edges;
        sortByCost(edges, numberOfNodes);
    }

    ArrayList getEdges() {
        return new ArrayList<>(Arrays.asList(this.edges));
    }

    int getNumberOfStages() {
        return numberOfNodes;
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

    private static void sortByCost(Edge[] edges, int n) {
        for (int k = n/2; k > 0; k--)
            descend(edges, k, n);
        Edge aux;
        for (int k = n; k > 0; k--) {
            descend(edges,0,k);
            aux = edges[0];
            edges[0] = edges[k];
            edges[k] = aux;
        }
    }

    private static void descend(Edge[] edges, int start, int end) {
        int father = start;
        Edge save = edges[father];
        int son = 2*father;
        while (son <= end) {
            if (son < end) {
                if(edges[son].getCost() < edges[son+1].getCost())
                    son++;
            }
            if (save.getCost() >= edges[son].getCost()) {
                edges[father] = save;
                return;
            } else {
                edges[father] = edges[son];
                father = son;
                son = 2*father;
            }
        }
        edges[father] = save;
    }

}