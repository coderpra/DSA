/*Java Program to find DFS (Depth First Search) of a Graph using Stack Data Structure. */
import java.util.*;

public class Main {

    private static void DFS(ArrayList<ArrayList<Integer>> graph, int startIndex, ArrayList<Integer> ans) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startIndex);

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();

            if (!ans.contains(currentNode + 1)) {
                ans.add(currentNode + 1); // Adjusted for zero-based indices

                // Push unvisited neighbors onto the stack
                for (var neighbor : graph.get(currentNode)) {
                    if (!ans.contains(neighbor)) {
                        stack.push(neighbor - 1);
                    }
                }
            }
        }
    }

    private static ArrayList<Integer> PerformDFS(ArrayList<ArrayList<Integer>> graph) {
        ArrayList<Integer> ans = new ArrayList<>(); // Create an array using ArrayList to store the DFS traversal
        DFS(graph, 0, ans); // Start DFS traversal from the first vertex (index 0)
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices and number of edges (separate them using a space like: V E): ");
        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(vertices);

        // Initialize the ArrayList for each vertex
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges; i++) {
            System.out.print("Enter the two vertices connected with an undirected edge (separate them using a space like: V1 V2): ");
            int vertex1 = sc.nextInt();
            int vertex2 = sc.nextInt();

            // Check if edge already exists
            if (graph.get(vertex1 - 1).contains(vertex2)) {
                i--;
                System.out.print("Edge already exists.\n Please Again, ");
                continue;
            } else {
                // Update the adjacency list for an undirected graph
                graph.get(vertex1 - 1).add(vertex2);
                graph.get(vertex2 - 1).add(vertex1);
            }
        }

        // Output: DFS traversal of the graph
        System.out.println("DFS traversal of the graph: " + PerformDFS(graph));
        sc.close();
    }
}
