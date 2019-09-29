package nl.knaake.erik.datastructures.graphs;

import nl.knaake.erik.datastructures.ListNode;

import java.util.Arrays;
import java.util.Collection;

public class GraphMatrix {
    private Double[][] matrix;

    public GraphMatrix(int numVertex) {
        matrix = new Double[numVertex][numVertex];
    }

    public static void setEdge(Vertex v, Vertex v2, int from, int to, GraphMatrix graphMatrix) {
        ListNode<Edge> node = v.getAdjecent().getHeader().getNext();
        while(node != null) {
            if(node.getValue().getDestination().equals(v2)) {
                graphMatrix.matrix[from][to] = node.getValue().getCost();
                return;
            }
            node = node.getNext();
        }
        graphMatrix.matrix[from][to] = null;
    }

    public static GraphMatrix fromVertices(Collection<Vertex> vertices) {
        GraphMatrix graphMatrix = new GraphMatrix(vertices.size());
        int i = 0;
        for(Vertex v: vertices) {
            int j = 0;
            for(Vertex v2: vertices) {
                setEdge(v, v2, i, j, graphMatrix);
                j++;
            }
            i++;
        }
        return graphMatrix;
    }

    public Double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(Double[][] matrix) {
        this.matrix = matrix;
    }

    public boolean isUndirectedConnected() {
        boolean[] visited = new boolean[matrix.length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                traverse(i, visited);
            }
            for(boolean b : visited) {
                if(!b)
                    return false;
            }
        }
        return true;
    }

    private void traverse(int node, boolean[] visited) {
        visited[node] = true;
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[node][i] != null && !visited[i])
                    traverse(i, visited);
        }
    }
}
