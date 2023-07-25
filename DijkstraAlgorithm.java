
import java.util.*;

public class DijkstraAlgorithm {
    static class Edge {
        int target;
        int weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    static void dijkstra(List<List<Edge>> graph, int source) {
        int V = graph.size();
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Priority queue to keep track of nodes with the minimum distance
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> distance[o]));
        pq.add(source);

        while (!pq.isEmpty()) {
            int u = pq.poll();

            for (Edge edge : graph.get(u)) {
                int v = edge.target;
                int weight = edge.weight;

                if (distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                    pq.add(v);
                }
            }
        }

        // Print the shortest distances from the source node to all other nodes
        for (int i = 0; i < V; i++) {
            System.out.println("Shortest distance from node " + source + " to node " + i + ": " + distance[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        List<List<Edge>> graph = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Adding edges to the graph (example graph with weighted edges)
        graph.get(0).add(new Edge(1, 9));
        graph.get(0).add(new Edge(2, 6));
        graph.get(0).add(new Edge(3, 5));
        graph.get(0).add(new Edge(4, 3));
        graph.get(2).add(new Edge(1, 2));
        graph.get(2).add(new Edge(3, 4));

        int sourceNode = 0; // Source node for Dijkstra's algorithm
        dijkstra(graph, sourceNode);
    }
}
