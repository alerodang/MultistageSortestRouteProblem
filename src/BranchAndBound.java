import java.util.ArrayList;
import java.util.List;

/***
 * This class represents shortest route tree generate due to find the shortest route in a graph search
 * Every branch of the graph ends in the searched node
 */
class BranchAndBound {
    private Node goal;
    private List<Edge> edgesToAttend;
    private Graph graph;
    private Route shortestRoute;
    private List<Node> visitedNodes = new ArrayList<>();

    BranchAndBound(Node goal, Graph graph) {
        this.goal = goal;
        this.graph = graph;
        this.edgesToAttend = graph.getEdges();
        this.shortestRoute = new Route(Integer.MAX_VALUE);
    }

    Route CalculateAndGetShortestRoute(){
        Route route = new Route(0);
        findShortestRoute(graph.getRoot(), route);
        return shortestRoute;
    }

    private void findShortestRoute(Node node, Route route){
        if (node.equals(goal) && route.getCost() < shortestRoute.getCost())
            shortestRoute = route;
        else expand(node, route);
    }

    private void expand(Node currentNode, Route route) {
        for (Edge edge : edgesToAttend) {
            if (currentNode.equals(edge.getSmallestStageNode())) {
                int minimumCost = ((route.getCost() + edge.getCost() + graph.getNumberOfStages()) - (currentNode.getStage() + 2));
                if ( minimumCost < shortestRoute.getCost() ) {
                    visitedNodes.add( edge.getBiggestStageNode());
                    findShortestRoute( edge.getBiggestStageNode(), route.copy().addEdge(edge));
                }
                if(edge.getBiggestStageNode().equals(goal)) break;
            }
        }
    }

    List<Node> getVisitedNodes() {
        return visitedNodes;
    }
}