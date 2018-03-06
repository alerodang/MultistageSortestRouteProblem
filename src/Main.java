public class Main {

    public static void main(String[] args) {

        /*Graph 1*/
        System.out.println("\n***Graph 1***");
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
                new Edge(3, root, n12),
                new Edge(2, root, n13),
                new Edge(1, n11, goal),
                new Edge(5, n11, n21),
                new Edge(3, n11, n23),
                new Edge(4, n12, n21),
                new Edge(3, n12, n22),
                new Edge(2, n13, n22),
                new Edge(7, n13, n23),
                new Edge(4, n21, goal),
                new Edge(1, n22, goal),
                new Edge(1, n23, goal)
        };

        Graph graph1 = new Graph(listOfEdgesGraph1, root, goal);
        BranchAndBound branchAndBound1 = new BranchAndBound(goal,graph1);
        Route obtainedRoute1 = branchAndBound1.CalculateAndGetShortestRoute();
        Route expectedRoute1 = new Route(0);
        expectedRoute1.addEdge(listOfEdgesGraph1[0]);
        expectedRoute1.addEdge(listOfEdgesGraph1[5]);
        expectedRoute1.addEdge(listOfEdgesGraph1[12]);
        if(obtainedRoute1.toString().equals(expectedRoute1.toString())) System.out.println("\nShortest Route correctly " +
                "found:" + obtainedRoute1);
        System.out.println("\nExpanded nodes:");
        System.out.println(branchAndBound1.getVisitedNodes());


        /*Graph 2*/
        System.out.println("\n***Graph 2***");
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
                new Edge(1, root, n11),
                new Edge(2, root, n12),
                new Edge(3, root, n13),
                new Edge(4, root, n14),
                new Edge(1, n11, n21),
                new Edge(1, n12, n21),
                new Edge(1, n13, n21),
                new Edge(1, n14, n22),
                new Edge(10, n21, n31),
                new Edge(1, n22, n32),
                new Edge(1, n31, n32),
                new Edge(1, n31, goal),
                new Edge(2, n32, goal)
        };

        Graph graph2 = new Graph(listOfEdgesGraph2, root, goal);
        BranchAndBound branchAndBound2 = new BranchAndBound(goal,graph2);
        Route obtainedRoute2 = branchAndBound2.CalculateAndGetShortestRoute();
        Route expectedRoute2 = new Route(0);
        expectedRoute2.addEdge(listOfEdgesGraph2[3]);
        expectedRoute2.addEdge(listOfEdgesGraph2[7]);
        expectedRoute2.addEdge(listOfEdgesGraph2[9]);
        expectedRoute2.addEdge(listOfEdgesGraph2[12]);
        if(obtainedRoute2.toString().equals(expectedRoute2.toString())) System.out.println("\nShortest Route correctly " +
                "found:" + obtainedRoute2);
        System.out.println("\nExpanded nodes:");
        System.out.println(branchAndBound2.getVisitedNodes());

        /*Graph 3*/
        System.out.println("\n***Graph 3***");
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
        BranchAndBound branchAndBound3 = new BranchAndBound(goal,graph3);
        Route obtainedRoute3 = branchAndBound3.CalculateAndGetShortestRoute();
        Route expectedRoute3 = new Route(0);
        expectedRoute3.addEdge(listOfEdgesGraph3[0]);
        expectedRoute3.addEdge(listOfEdgesGraph3[2]);
        expectedRoute3.addEdge(listOfEdgesGraph3[4]);
        if(obtainedRoute3.toString().equals(expectedRoute3.toString())) System.out.println("\nShortest Route correctly " +
                "found:" + obtainedRoute3);
        System.out.println("\nExpanded nodes:");
        System.out.println(branchAndBound3.getVisitedNodes());

    }

}