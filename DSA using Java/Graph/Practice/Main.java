import java.util.*;

class Graph {
    private ArrayList<ArrayList<Integer>> graph;
    private int v, e;

    public Graph(int v, int e) {
        this.v = v;
        this.e = e;
        graph = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
    }

    private void addEdge(int src, int dest) {
        graph.get(src - 1).add(dest);
        graph.get(dest - 1).add(src); // for undirected graph
    }

    public void createGraph() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < e; i++) {
            System.out.print("Enter the two vertices connected with an undirected edge (separate them using a space like: V1 V2): ");
            int vertix1 = sc.nextInt();
            int vertix2 = sc.nextInt();

            // Input validation
            if (vertix1 < 1 || vertix1 > v || vertix2 < 1 || vertix2 > v) {
                System.out.println("Invalid vertices. Please enter vertices between 1 and " + v + ".");
                i--; // Decrement i to re-prompt for input
                continue;
            }

            // Check if edge already exists
            else if (graph.get(vertix1 - 1).contains(vertix2)) {
                i--;
                System.out.print("Edge already exists.\n Please Again, ");
                continue;
            } else {
                // Update the adjacency list for an undirected graph
                addEdge(vertix1, vertix2);
            }
        }
        sc.close();
    }

    public ArrayList<Integer> bfs() {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v];

        visited[0] = true;
        queue.add(1);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            result.add(vertex);

            for (int neighbour : graph.get(vertex - 1)) {
                if (!visited[neighbour - 1]) {
                    visited[neighbour - 1] = true;
                    queue.add(neighbour);
                }
            }
        }

        return result;
    }

    private void performDFS(ArrayList<Integer> result, Stack<Integer> Helperstack, boolean[] visited, int vertixNumber) {
        Helperstack.push(vertixNumber);
        while (!Helperstack.isEmpty()) {
            vertixNumber = Helperstack.peek();
            Helperstack.pop();
            if (!visited[vertixNumber - 1]) {
                result.add(vertixNumber);
                visited[vertixNumber - 1] = true;
            }
            for (int neighbour : graph.get(vertixNumber - 1)) {
                if (!visited[neighbour - 1]) {
                    Helperstack.push(neighbour);
                }
            }
        }
    }

    public ArrayList<Integer> dfs() {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> Helperstack = new Stack<>();
        boolean[] visited = new boolean[v];
        performDFS(result, Helperstack, visited, 1); // Start DFS from vertex 1
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Vertices and Edges: ");
        int v = sc.nextInt();
        int e = sc.nextInt();

        Graph g = new Graph(v, e);
        g.createGraph();

        System.out.println("The BFS Traversal of the graph is: " + g.bfs());
        System.out.println("The DFS Traversal of the graph is: " + g.dfs());
        sc.close();
    }
}
