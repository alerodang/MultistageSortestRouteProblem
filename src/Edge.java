public class Edge {
    /*Nodes are ordered by stages, node1 is the one with the smallest stage*/
    private Node node1, node2;
    private int cost;

    Edge( int cost, Node node1, Node node2) {
        if (node1.getStage() < node2.getStage()) {
            this.node1 = node1;
            this.node2 = node2;
        } else {
            this.node1 = node2;
            this.node2 = node1;
        }
        this.cost = cost;
    }

    Node getBiggestStageNode() {
        return node2;
    }

    Node getSmallestStageNode() {
        if (!isValid()) return null;
        return node1;
    }

    private boolean isValid (){
        return(node1.getStage() == node2.getStage() - 1);
    }

    int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "node1=" + node1.getStage() + "," + node1.getId() +
                "  node2=" + node2.getStage() + "," + node2.getId() +
                "  cost=" + cost +
                '}';
    }

}
