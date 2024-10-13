public class GraphImplementation {
    public static void main(String[] args) {
        Graph ourGraph = new Graph();

        //vertices
        Vertex v0 = new Vertex("A");
        Vertex v1 = new Vertex("B");
        Vertex v2 = new Vertex("C");
        Vertex v3 = new Vertex("D");
        Vertex v4 = new Vertex("E");
        Vertex v5 = new Vertex("F");

        ourGraph.AddVertex(v0);

        ourGraph.AddVertex(v1);
        ourGraph.AddVertex(v2);
        ourGraph.AddVertex(v3);
        ourGraph.AddVertex(v4);
        ourGraph.AddVertex(v5);

        //edges
        ourGraph.AddEdge(v0, v1, 1); // A

        ourGraph.AddEdge(v1, v0, 1);
        ourGraph.AddEdge(v1, v2, 1);
        ourGraph.AddEdge(v1, v3, 1); // B
        ourGraph.AddEdge(v1, v4, 1);

        ourGraph.AddEdge(v2, v1, 1);
        ourGraph.AddEdge(v2, v4, 1); // C

        ourGraph.AddEdge(v3, v1, 1); // D
        ourGraph.AddEdge(v3, v4, 1);

        ourGraph.AddEdge(v4, v1, 1);
        ourGraph.AddEdge(v4, v2, 1); // E
        ourGraph.AddEdge(v4, v3, 1);

        ourGraph.AddEdge(v5, v4, 1); // F


        ourGraph.printGraph();

        System.out.println("\nRunning Floyd-Warshall algorithm:");
        ourGraph.runFloydWarshallAlgorithm();

    }
}