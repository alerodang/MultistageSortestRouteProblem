import java.util.ArrayList;
/***
 * This class represents a route into the graph. Allows any route.
 */
public class Route {
    private int cost;
    private ArrayList <Edge> edges = new ArrayList<>();

    Route(int cost) {
        this.cost = cost;
    }

    Route addEdge(Edge edge){
        this.edges.add(edge);
        this.cost += edge.getCost();
        return this;
    }

    int getCost(){
        return cost;
    }

    Route copy() {
        Route route = new Route(this.getCost());
        route.edges.addAll(this.edges);
        return route;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Edge edge: edges) string.append(edge.toString()).append("\n");
        return string.toString();
    }

}
