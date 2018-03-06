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

    @Override
    public String toString(){
        return "node: "+this.stage+"-"+this.id;
    }

}