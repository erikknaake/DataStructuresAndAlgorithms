package nl.knaake.erik.datastructures.graphs;

public class Edge {
    private Vertex destination;
    private double cost;

    public Edge(Vertex destination, double cost) {
        this.destination = destination;
        this.cost = cost;
    }

    public Vertex getDestination() {
        return destination;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "destination=" + destination +
                ", cost=" + cost +
                '}';
    }
}
