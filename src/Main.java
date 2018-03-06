public class Main {

    public static void main(String[] args) {


        System.out.println("**Graph 1**");
        Node root = new Node(0, 0);
        Node n11 = new Node( 1,1);
        Node n12 = new Node( 2,1);
        Node n13 = new Node( 3,1);
        Node n21 = new Node( 1,2);
        Node n22 = new Node( 2,2);
        Node n23 = new Node( 3,2);
        Node goal = new Node( 0,3);

        Edge[] listOfEdgesGraph1 = {
                new Edge(1, root, n11),
                new Edge(5, n11, n21),
                new Edge(3, n11, n23),
                new Edge(3, root, n12),
                new Edge(2, root, n13),
                new Edge(4, n21, goal),
                new Edge(4, n12, n21),
                new Edge(3, n12, n22),
                new Edge(2, n13, n22),
                new Edge(7, n13, n23),
                new Edge(1, n22, goal),
                new Edge(1, n23, goal),
                new Edge(1, n11, goal)
        };

        Graph graph1 = new Graph(listOfEdgesGraph1, root, goal);
        Route obtainedRoute1 = new BranchAndBound(goal,graph1).CalculateAndGetShortestRoute();



        System.out.println("**Graph 2**");
        root = new Node(0,0);
        n11 = new Node( 1,1);
        n12 = new Node( 2,1);
        n13 = new Node( 3,1);
        Node n14 = new Node(4,1);
        n21 = new Node( 1,2);
        n22 = new Node( 2,2);
        Node n31 = new Node( 1,3);
        Node n32 = new Node(2,3);
        goal = new Node(0,4);

        Edge[] listOfEdgesGraph2 = {
                new Edge(2, root, n11),
                new Edge(1, root, n12),
                new Edge(3, root, n13),
                new Edge(5, root, n14),
                new Edge(1, n11, n21),
                new Edge(3, n12, n11),
                new Edge(4, n12, n21),
                new Edge(1, n12, n22),
                new Edge(7, n13, n21),
                new Edge(1, n13, n22),
                new Edge(2, n14, n22),
                new Edge(2, n21, n31),
                new Edge(1, n22, n31),
                new Edge(6, n22, n32),
                new Edge(1, n31, n32),
                new Edge(4, n31, goal),
                new Edge(2, n32, goal)
        };

        Graph graph2 = new Graph(listOfEdgesGraph2, root, goal);
        Route obtainedRoute2 = new BranchAndBound(goal,graph2).CalculateAndGetShortestRoute();


        System.out.println("**Graph 3**");
        root = new Node(0,0);
        n11 = new Node( 1,1);
        n12 = new Node( 2,1);
        n21 = new Node( 1,2);
        goal = new Node(0,3);

        Edge[] listOfEdgesGraph3 = {
                new Edge(1, root, n11),
                new Edge(2, root, n12),
                new Edge(1, n11, n21),
                new Edge(1, n12, n21),
                new Edge(1, n21, goal)
        };

        Graph graph3 = new Graph(listOfEdgesGraph3, root, goal);
        Route obtainedRoute3 = new BranchAndBound(goal,graph3).CalculateAndGetShortestRoute();
        Route expectedRoute3 = new Route(0);
        expectedRoute3.addEdge(listOfEdgesGraph3[0]);
        expectedRoute3.addEdge(listOfEdgesGraph3[2]);
        expectedRoute3.addEdge(listOfEdgesGraph3[4]);

        if(obtainedRoute3.toString().equals(expectedRoute3.toString())) System.out.println("\nCorrect Solution: "
            + obtainedRoute3);

    }

}