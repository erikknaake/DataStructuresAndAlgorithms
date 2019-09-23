package nl.knaake.erik.datastructures.graphs;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GraphTest {
    private Graph graph;

    @Before
    public void before() {
        graph = new Graph();
        graph.addEdge("Amsterdam", "Haarlem", 1);
        graph.addEdge("Haarlem", "Den Haag", 1);

        graph.addEdge("Amsterdam", "Rotterdam", 3);
        graph.addEdge("Den Haag", "Rotterdam", 1);
    }

    @Test
    public void uweightedDirectConnection() {
        graph.addEdge("Amsterdam", "Den Haag", 3);
        graph.unweighted("Amsterdam");

        assertEquals("Amsterdam isDistance: 0.0 to Den Haag isDistance: 1.0", graph.pathToString("Den Haag"));
    }

    @Test
    public void unweightedOnlyOneOption() {
        graph.addEdge("Den Haag", "Utrecht", 3);
        graph.unweighted("Amsterdam");

        assertEquals("Amsterdam isDistance: 0.0 to Haarlem isDistance: 1.0 to Den Haag isDistance: 2.0 to Utrecht isDistance: 3.0", graph.pathToString("Utrecht"));
    }

    @Test
    public void unweightedMultipleOptions() {
        graph.unweighted("Amsterdam");

        assertEquals("Amsterdam isDistance: 0.0 to Haarlem isDistance: 1.0 to Den Haag isDistance: 2.0", graph.pathToString("Den Haag"));
    }

    @Test
    public void unweightedMultiCallsDirectConnection() {
        graph.addEdge("Amsterdam", "Den Haag", 1.2);
        graph.unweighted("Amsterdam");
        graph.unweighted("Den Haag");

        assertEquals("Den Haag isDistance: 0.0 to Rotterdam isDistance: 1.0", graph.pathToString("Rotterdam"));
    }


    @Test
    public void dijkstraDirectConnection() {
        graph.addEdge("Amsterdam", "Den Haag", 1.2);
        graph.dijkstra("Amsterdam");

        assertEquals("Amsterdam isDistance: 0.0 to Den Haag isDistance: 1.2", graph.pathToString("Den Haag"));
    }

    @Test
    public void dijkstraMultiCallsDirectConnection() {
        graph.addEdge("Amsterdam", "Den Haag", 1.2);
        graph.dijkstra("Amsterdam");
        graph.dijkstra("Den Haag");

        assertEquals("Den Haag isDistance: 0.0 to Rotterdam isDistance: 1.0", graph.pathToString("Rotterdam"));
    }

    @Test
    public void dijkstraOnlyOneOption() {
        graph.addEdge("Den Haag", "Utrecht", 3);
        graph.dijkstra("Amsterdam");

        assertEquals("Amsterdam isDistance: 0.0 to Haarlem isDistance: 1.0 to Den Haag isDistance: 2.0 to Utrecht isDistance: 5.0", graph.pathToString("Utrecht"));
    }

    @Test
    public void dijkstraMultipleOptions() {
        graph.dijkstra("Amsterdam");

        assertEquals("Amsterdam isDistance: 0.0 to Haarlem isDistance: 1.0 to Den Haag isDistance: 2.0", graph.pathToString("Den Haag"));
    }

    @Test
    public void dijkstraLessLinksMoreCost() {
        graph.addEdge("Haarlem", "Rotterdam", 1.9); // Amsterdam --> Haarlem = 1, Haarlem --> Rotterdam = 1.9, Amsterdam --> Haarlem --> Rotterdam = 2.9
        graph.dijkstra("Amsterdam");
        assertEquals("Amsterdam isDistance: 0.0 to Haarlem isDistance: 1.0 to Rotterdam isDistance: 2.9", graph.pathToString("Rotterdam")); // Direct route Amsterdam --> Rotterdam = 3
    }

    @Test
    public void nonExistingEnd() {
        graph.dijkstra("Amsterdam");
        assertEquals("", graph.pathToString("Zutphen"));
    }

    @Test
    public void unreachableDirections() {
        graph.addEdge("A", "C", 1);
        graph.dijkstra("C");
        assertEquals("A isDistance: Infinity", graph.pathToString("A"));
    }

    @Test
    public void scratched() {
        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "C", 1);
        graph.addEdge("B", "E", 1);
        graph.addEdge("B", "D", 5);
        graph.addEdge("B", "C", 7);
        graph.addEdge("C", "D", 2);
        graph.addEdge("D", "E", 7);

        graph.addEdge("B", "A", 3);
        graph.addEdge("C", "A", 1);
        graph.addEdge("E", "B", 1);
        graph.addEdge("D", "B", 5);
        graph.addEdge("C", "B", 7);
        graph.addEdge("D", "C", 2);
        graph.addEdge("E", "D", 7);

        graph.dijkstra("C");
        assertEquals("C isDistance: 0.0 to A isDistance: 1.0", graph.pathToString("A"));
    }

    @Test
    public void onlyConnectedInOneDirectionDirectional() {
        assertFalse(graph.isConnectedDirectional());
    }

    @Test
    public void connectedBothDirectionsDirectional() {
        graph.addEdge("Haarlem", "Amsterdam", 1);
        graph.addEdge("Den Haag", "Haarlem", 1);

        graph.addEdge("Rotterdam", "Amsterdam", 3);
        graph.addEdge("Rotterdam","Den Haag", 1);

        assertTrue(graph.isConnectedDirectional());
    }

    @Test
    public void onlyConnectedInOneDirectionUndirectional() {
        assertFalse(graph.isConnectedUndirectional());
    }

    @Test
    public void connectedBothDirectionsUndirectional() {
        graph.addEdge("Haarlem", "Amsterdam", 1);
        graph.addEdge("Den Haag", "Haarlem", 1);

        graph.addEdge("Rotterdam", "Amsterdam", 3);
        graph.addEdge("Rotterdam","Den Haag", 1);
        assertTrue(graph.isConnectedUndirectional());
    }

    @Test
    public void connectedEmptyDirectional() {
        graph = new Graph();
        assertTrue(graph.isConnectedDirectional());
    }

    @Test
    public void connectedEmptyUndirectional() {
        graph = new Graph();
        assertTrue(graph.isConnectedUndirectional());
    }

    @Test
    public void compareEqualPaths() {
        Vertex v = new Vertex("A");
        assertEquals(0, new Path(v, 1).compareTo(new Path(v, 1)));
    }

    @Test
    public void comparePathsUnequalCostSmaller() {
        Vertex v = new Vertex("A");
        assertEquals(-1, new Path(v, 1).compareTo(new Path(v, 2)));
    }

    @Test
    public void comparePathsUnequalCostGreater() {
        Vertex v = new Vertex("A");
        assertEquals(1, new Path(v, 2).compareTo(new Path(v, 1)));
    }


    @Test
    public void toStringTest() {
        assertEquals("Graph{vertexMap={Rotterdam=Vertex{name='Rotterdam', adjecent=LinkedList:\n" +
                "Empty\n" +
                ", distance=Infinity, scratched=false}, Amsterdam=Vertex{name='Amsterdam', adjecent=LinkedList:\n" +
                "\t0: Edge{destination=Vertex{name='Rotterdam', adjecent=LinkedList:\n" +
                "Empty\n" +
                ", distance=Infinity, scratched=false}, cost=3.0}\n" +
                "\t1: Edge{destination=Vertex{name='Haarlem', adjecent=LinkedList:\n" +
                "\t0: Edge{destination=Vertex{name='Den Haag', adjecent=LinkedList:\n" +
                "\t0: Edge{destination=Vertex{name='Rotterdam', adjecent=LinkedList:\n" +
                "Empty\n" +
                ", distance=Infinity, scratched=false}, cost=1.0}\n" +
                ", distance=Infinity, scratched=false}, cost=1.0}\n" +
                ", distance=Infinity, scratched=false}, cost=1.0}\n" +
                ", distance=Infinity, scratched=false}, Haarlem=Vertex{name='Haarlem', adjecent=LinkedList:\n" +
                "\t0: Edge{destination=Vertex{name='Den Haag', adjecent=LinkedList:\n" +
                "\t0: Edge{destination=Vertex{name='Rotterdam', adjecent=LinkedList:\n" +
                "Empty\n" +
                ", distance=Infinity, scratched=false}, cost=1.0}\n" +
                ", distance=Infinity, scratched=false}, cost=1.0}\n" +
                ", distance=Infinity, scratched=false}, Den Haag=Vertex{name='Den Haag', adjecent=LinkedList:\n" +
                "\t0: Edge{destination=Vertex{name='Rotterdam', adjecent=LinkedList:\n" +
                "Empty\n" +
                ", distance=Infinity, scratched=false}, cost=1.0}\n" +
                ", distance=Infinity, scratched=false}}}", graph.toString());
    }
}
