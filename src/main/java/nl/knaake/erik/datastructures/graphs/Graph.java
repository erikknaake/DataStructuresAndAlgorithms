package nl.knaake.erik.datastructures.graphs;

import nl.knaake.erik.datastructures.HANQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Graph {
    public final static double INFINITY = Double.POSITIVE_INFINITY;

    private Map<String, Vertex> vertexMap;

    public Graph() {
        vertexMap = new HashMap<>();
    }

    public void addEdge(String source, String destination, double cost) {
        Vertex src = getOrMakeVertex(source);
        Vertex dest = getOrMakeVertex(destination);
        src.addAdjecent(dest, cost);
    }

    private Vertex getOrMakeVertex(String name) {
        Vertex vertex = vertexMap.get(name);
        if(vertex == null) {
            vertex = new Vertex(name);
            vertexMap.put(name, vertex);
        }
        return vertex;
    }

    private void clear() {
        for(Vertex v : vertexMap.values())
            v.reset();
    }

    public String pathToString(String destName) {
        Vertex dest = vertexMap.get(destName);
        if(dest == null)
            return "";
        return pathToString(dest);
    }

    public String pathToString(Vertex dest) {
        return pathToString(dest, "");
    }

    private String pathToString(Vertex dest, String currentString) {
        if(dest.getPrevious() != null) {
            currentString += pathToString(dest.getPrevious(), currentString);
            currentString +=" to ";
        }
        currentString += (dest.getName() + " isDistance: " + dest.getDistance());
        return currentString;
    }

    public void unweighted(String startName) {
        clear();
        Vertex start = vertexMap.get(startName);
        HANQueue<Vertex> queue = new HANQueue<>();
        start.setDistance(0);
        queue.enqueue(start);

        while(!queue.isEmpty()) {
            queue.dequeue().setEdgeDistances(queue);
        }
    }

    public void dijkstra(String startName) {
        clear();
        Vertex start = vertexMap.get(startName);

        PriorityQueue<Path> queue = new PriorityQueue<>();
        queue.add(new Path(start, 0));
        start.setDistance(0);
        int nodesSeen = 0;

        while(!queue.isEmpty() && nodesSeen < vertexMap.size()) {
            Vertex v = queue.poll().getDestination();

            if(v.isScratched())
                continue;
            v.setScratched();
            nodesSeen++;
            v.setEdgeDistances(queue);
        }
    }

    @Override
    public String toString() {
        return "Graph{" +
                "vertexMap=" + vertexMap +
                '}';
    }
}
