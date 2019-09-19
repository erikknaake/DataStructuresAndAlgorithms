package nl.knaake.erik.datastructures.graphs;

import nl.knaake.erik.datastructures.HANLinkedList;
import nl.knaake.erik.datastructures.HANQueue;
import nl.knaake.erik.datastructures.ListNode;

import java.util.PriorityQueue;

public class Vertex {
    private String name;
    private HANLinkedList<Edge> adjecent;
    private double distance;
    private  Vertex previous;
    boolean scratched;

    public Vertex(String name) {
        this.name = name;
        adjecent = new HANLinkedList<>();
        reset();
    }

    public void reset() {
        distance = Graph.INFINITY;
        previous = null;
        scratched = false;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Vertex getPrevious() {
        return previous;
    }

    public boolean isScratched() {
        return scratched;
    }

    public void setScratched() {
        scratched = true;
    }

    public String getName() {
        return name;
    }

    public void addAdjecent(Vertex destination, double cost) {
        adjecent.addFirst(new Edge(destination, cost));
    }

    public void setEdgeDistances(HANQueue<Vertex> queue) {
        ListNode<Edge> e = adjecent.findNode(0);
        while(e != null && e.getValue() != null) {
              Vertex w = e.getValue().getDestination();

              if(w.distance == Graph.INFINITY) {
                w.distance = this.distance + 1;
                w.previous = this;
                queue.enqueue(w);
              }
              e = e.getNext();
        }
    }

    public void setEdgeDistances(PriorityQueue<Path> queue) {
        ListNode<Edge> e = adjecent.findNode(0);
        while(e != null && e.getValue() != null) {
            Vertex w = e.getValue().getDestination();
            double cost = e.getValue().getCost();

            if(w.distance > distance + cost) {
                w.distance = this.distance + cost;
                w.previous = this;
                queue.add(new Path(w, w.distance));
            }
            e = e.getNext();
        }
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                ", adjecent=" + adjecent +
                ", distance=" + distance +
                ", scratched=" + scratched +
                '}';
    }
}
