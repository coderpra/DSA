/*Program to find Breath First Search(BFS) of an Undireced Graph */
import java.util.*;
public class Main {
    private static ArrayList<Integer> BFS(ArrayList<ArrayList<Integer>> list){
        int v = list.size(); //get the number of vertices present in the graph which is actually the size of the graph
        Queue<Integer> queue = new LinkedList<>();
        int visited [] = new int[v];
        ArrayList<Integer> bfs = new ArrayList<>(v);

        queue.add(1); //assuming the graph is connected with vertix 1
        visited[0]=1;
        bfs.add(1); // Add the first vertex to the BFS list
        while(!queue.isEmpty()){
            int node =queue.poll();

            for(int neighbor : list.get(node-1)){ // Iterate through the neighbors of the current node
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
        int v = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(v);

        // Initialize the ArrayList for each vertex
        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            System.out.print("Enter the two vertices connected with an undirected edge (separate them using a space like: E1 E2): ");
            int e1 = sc.nextInt();
            int e2 = sc.nextInt();

            // Check if edge already exists
            if (list.get(e1 - 1).contains(e2)) {
                i--;
                System.out.print("Edge already exists.\n Please Again, ");
                continue;
            } else {
                // Update the adjacency list for an undirected graph
                list.get(e1 - 1).add(e2);
                list.get(e2 - 1).add(e1);
            }
        }
        
        System.out.println("BFS --> "+BFS(list)); // Output the BFS result
        sc.close();
    }
}
