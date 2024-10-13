import java.util.*;

class Graph {
    private final Set<Vertex> nodes;

    public Graph() {
        nodes = new LinkedHashSet<>();
    }

    public void AddEdge(Vertex v1, Vertex v2, int weight) {
        v1.getEdges().add(new Edge(v2, weight));
    }

    public void AddVertex(Vertex v) {
        nodes.add(v);
    }

    public ArrayList<Vertex> getVertices() {
        return new ArrayList<>(nodes);
    }


    public void printGraph() {
        for (Vertex v : nodes) {
            System.out.print("vertex name: " + v.getName() + ": ");
            for (Edge e : v.getEdges()) {
                System.out.print("destVertex: " + e.getDestVertex().getName() + " weight: " + e.getWeight() + " | ");
            }
            System.out.print("\n");
        }
    }

    public void runFloydWarshallAlgorithm() {
        FWAlg algorithm = new FWAlg(this);
        algorithm.runAlgorithm();
        double[][] distanceMatrix = algorithm.getDistanceMatrix();
        Iterator<Vertex> iterator = nodes.iterator();

        System.out.println("Shortest distances:");
        System.out.print("   ");
        for (Vertex node : nodes) {
            System.out.print(" " + node.getName() + "  ");
        }
        System.out.println();

        for (int i = 0; i < nodes.size(); i++) {

            Vertex node = iterator.next();
            System.out.print(node.getName() + "  ");

            for (int j = 0; j < nodes.size(); j++) {
                if (distanceMatrix[i][j] == Double.POSITIVE_INFINITY) {
                    System.out.print("INF ");
                } else {
                    System.out.printf("%.1f ", distanceMatrix[i][j]);
                }
            }
            System.out.println();
        }
    }
}