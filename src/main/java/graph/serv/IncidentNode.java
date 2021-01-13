package graph.serv;

public class IncidentNode {
    public Node node;
    public double weight;

    public IncidentNode() {
    }

    public IncidentNode(Node node) {
        this.node = node;
    }

    public IncidentNode(Node node, double weight) {
        this(node);
        this.weight = weight;
    }
}
