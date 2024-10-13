import java.util.Arrays;

public class FWAlg {

    private final Graph graph;
    private double[][] distanceMatrix;

    public FWAlg(Graph graph) {
        this.graph = graph;
        this.distanceMatrix = new double[graph.getVertices().size()][graph.getVertices().size()];
        initializeDistanceMatrix();
    }

    private void initializeDistanceMatrix() {
        int n = graph.getVertices().size();
        for (int i = 0; i < n; i++) {
            Arrays.fill(distanceMatrix[i], Double.POSITIVE_INFINITY);
            distanceMatrix[i][i] = 0;
        }

        for (Vertex vertex : graph.getVertices()) {
            for (Edge edge : vertex.getEdges()) {
                int u = graph.getVertices().indexOf(vertex);
                int v = graph.getVertices().indexOf(edge.getDestVertex());
                distanceMatrix[u][v] = edge.getWeight();
                distanceMatrix[v][u] = edge.getWeight();
            }
        }
    }

    public void runAlgorithm() {
        int n = graph.getVertices().size();
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distanceMatrix[i][j] = Math.min(distanceMatrix[i][j],
                            distanceMatrix[i][k] + distanceMatrix[k][j]);
                    distanceMatrix[j][i] = Math.min(distanceMatrix[j][i],
                            distanceMatrix[j][k] + distanceMatrix[k][i]);
                }
            }
        }
    }

    public double[][] getDistanceMatrix() {
        return distanceMatrix;
    }
}
