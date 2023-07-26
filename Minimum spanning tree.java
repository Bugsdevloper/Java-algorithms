import java.util.Arrays;

public class PrimMST {

    private int[][] graph;
    private int numOfNodes;

    public PrimMST(int[][] graph) {
        this.graph = graph;
        this.numOfNodes = graph.length;
    }

    public int[][] findMST() {
        int[][] mst = new int[numOfNodes][numOfNodes];
        boolean[] visited = new boolean[numOfNodes];
        int[] minDistances = new int[numOfNodes];
        int[] parentNodes = new int[numOfNodes];

        // Initialize arrays
        Arrays.fill(minDistances, Integer.MAX_VALUE);
        Arrays.fill(parentNodes, -1);

        // Start the MST from the first node (node 0)
        minDistances[0] = 0;
        parentNodes[0] = 0;

        // Loop until all nodes are visited
        for (int i = 0; i < numOfNodes - 1; i++) {
            int currentNode = findNextNode(minDistances, visited);
            visited[currentNode] = true;

            for (int j = 0; j < numOfNodes; j++) {
                if (graph[currentNode][j] != 0 && !visited[j] && graph[currentNode][j] < minDistances[j]) {
                    minDistances[j] = graph[currentNode][j];
                    parentNodes[j] = currentNode;
                }
            }
        }

        // Create the MST matrix from parent nodes
        for (int i = 0; i < numOfNodes; i++) {
            mst[i][parentNodes[i]] = minDistances[i];
            mst[parentNodes[i]][i] = minDistances[i];
        }

        return mst;
    }

    private int findNextNode(int[] minDistances, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int nextNode = -1;

        for (int i = 0; i < numOfNodes; i++) {
            if (!visited[i] && minDistances[i] < minDistance) {
                minDistance = minDistances[i];
                nextNode = i;
            }
        }

        return nextNode;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        PrimMST prim = new PrimMST(graph);
        int[][] mst = prim.findMST();

        System.out.println("Minimum Spanning Tree (MST):");
        for (int i = 0; i < mst.length; i++) {
            System.out.println(Arrays.toString(mst[i]));
        }
    }
}
