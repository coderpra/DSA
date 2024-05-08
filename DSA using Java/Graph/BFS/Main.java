/*Program to find Breath First Search(BFS) of an Undireced Graph */
import java.util.*;
public class Main {
    private static ArrayList<Integer> BFS(ArrayList<ArrayList<Integer>> graph){
        int v = graph.size(); //get the number of vertices present in the graph which is actually the size of the graph
        Queue<Integer> queue = new LinkedList<>();
        int visited [] = new int[v];
        ArrayList<Integer> bfs = new ArrayList<>(v);

        queue.add(1); //assuming the graph is connected with vertix 1
        visited[0]=1;
        bfs.add(1); // Add the first vertex to the BFS list
        while(!queue.isEmpty()){
            int node =queue.poll(); //used to retrieve and remove the front element (head) of the queue

            for(int neighbor : graph.get(node-1)){ // Iterate through the neighbors of the current node
                if(visited[neighbor-1]==1) continue;
                queue.add(neighbor);
                visited[neighbor-1]=1;
                bfs.add(neighbor); // Add the neighbor to the BFS list

            }
        }
        return bfs;
    }

    public static void main(String [] args){
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
            int Vertix1 = sc.nextInt();
            int Vertix2 = sc.nextInt();

            // Check if edge already exists
            if (graph.get(Vertix1 - 1).contains(Vertix2)) {
                i--;
                System.out.print("Edge already exists.\n Please Again, ");
                continue;
            } else {
                // Update the adjacency list for an undirected graph
                graph.get(Vertix1 - 1).add(Vertix2);
                graph.get(Vertix2 - 1).add(Vertix1);
            }
        }

        System.out.println("BFS --> "+BFS(graph)); // Output the BFS result
        sc.close();
    }
}
