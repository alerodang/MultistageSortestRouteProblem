import java.util.ArrayList;
import java.util.List;

/***
 * This class represents a route into the graph. Allows any route.
 */
public class Route {
    private int cost;
    private List <Edge> edges = new ArrayList<>();

    Route(int cost) {
        this.cost = cost;
    }

    Route addEdge(Edge edge){
        this.edges.add(edge);
        this.cost += edge.getCost();
        return this;
    }

    private void addEdges (List<Edge> edges){
        this.edges.addAll(edges);
    }

    Route copy () {
        Route route = new Route(this.cost);
        route.addEdges(this.edges);
        return route;
    }

    int getCost(){
        return cost;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Edge edge: edges) string.append("\n").append(edge.toString());
        return string.toString();
    }

}
