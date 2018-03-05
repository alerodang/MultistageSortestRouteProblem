import java.util.ArrayList;
/***
 * This class represents shortest route tree generate due to find the shortest route in a graph search
 * Every branch of the graph ends in the searched node
 */
class BranchAndBound {
    private Node goal;
    private ArrayList<Edge> edgesToAttend;
    private Graph graph;
    private Route shortestRoute;

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
        //If not --> get shortest Route of sons
        expand(node, route);
    }

    //Remove the first edge with the node from the edgesToAttend list, and add it to the route list
    private void expand(Node currentNode, Route route) {
        for (Edge edge : edgesToAttend) {   /*Must delete edges from original leed more memory free*/
            if (currentNode.equals(edge.getSmallestStageNode())/*¿This can be null?*/ && (route.getCost()
                    + edge.getCost() + graph.getNumberOfStages() - currentNode.getStage()) < shortestRoute.getCost()){
                findShortestRoute(edge.getBiggestStageNode(), (route.copy()).addEdge(edge));
            }
        }
    }
}
