import java.util.*;

public class TSPNearestNeighbor {

    private int[][] graph;
    private int numOfNodes;
    private List<Integer> tour;

    public TSPNearestNeighbor(int[][] graph) {
        this.graph = graph;
        this.numOfNodes = graph.length;
        this.tour = new ArrayList<>();
    }

    public List<Integer> solveTSP() {
        // Start from the first node (node 0)
        tour.add(0);

        // Keep track of visited nodes
        boolean[] visited = new boolean[numOfNodes];
        visited[0] = true;

        // Loop until all nodes are visited
        while (tour.size() < numOfNodes) {
            int currentNode = tour.get(tour.size() - 1);
            int nextNode = findNearestNeighbor(currentNode, visited);
            tour.add(nextNode);
            visited[nextNode] = true;
        }

        // Return to the starting node to complete the tour
        tour.add(0);

        return tour;
    }

    private int findNearestNeighbor(int node, boolean[] visited) {
        int nearestNeighbor = -1;
        int shortestDistance = Integer.MAX_VALUE;

        for (int i = 0; i < numOfNodes; i++) {
            if (!visited[i] && graph[node][i] < shortestDistance) {
                shortestDistance = graph[node][i];
                nearestNeighbor = i;
            }
        }

        return nearestNeighbor;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        TSPNearestNeighbor tsp = new TSPNearestNeighbor(graph);
        List<Integer> tour = tsp.solveTSP();

        System.out.println("TSP Tour: " + tour);
    }
}
