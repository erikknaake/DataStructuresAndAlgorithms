package nl.knaake.erik.datastructures.graphs;

public class Path implements Comparable<Path> {
    private Vertex destination;
    private double cost;

    public Path(Vertex destination, double cost) {
        this.destination = destination;
        this.cost = cost;
    }

    public Vertex getDestination() {
        return destination;
    }

    @Override
    public int compareTo(Path edge) {
        double otherCost = edge.cost;
        return Double.compare(cost, otherCost);
    }
}
