class Node {
    private int id;
    private int stage;

    Node(int id, int stage){
        this.id = id;
        this.stage = stage;
    }

    int getId() {
        return id;
    }

    int getStage() {
        return stage;
    }

   @Override
    public boolean equals(Object obj) {
        return obj instanceof Node && (((Node) obj).id == this.id && ((Node) obj).stage == this.stage);
    }

}