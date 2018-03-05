public class Main {

    public static void main(String[] args) {

        Node root = new Node(0, 0);
        Node n11 = new Node( 1,1);
        Node n12 = new Node( 2,1);
        Node n13 = new Node( 3,1);
        Node n21 = new Node( 1,2);
        Node n22 = new Node( 2,2);
        Node n23 = new Node( 3,2);
        Node goal = new Node( 0,3);

        Edge[] listOfEdges = {
                new Edge(1, root, n11),
                new Edge(3, root, n12),
                new Edge(2, root, n13),
                new Edge(5, n11, n21),
                new Edge(3, n11, n23),
                new Edge(4, n12, n21),
                new Edge(3, n12, n22),
                new Edge(2, n13, n22),
                new Edge(7, n13, n23),
                new Edge(4, n21, goal),
                new Edge(1, n22, goal),
                new Edge(1, n23, goal),
                new Edge(1, n11, n12),
                new Edge(1, n11, goal)
        };
        Graph graph = new Graph(listOfEdges, root, goal);

        System.out.println(graph.toString());

        BranchAndBound aux = new BranchAndBound(goal,graph);
        System.out.println(aux.CalculateAndGetShortestRoute());

    }

}