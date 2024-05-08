/* Java Program to find DFS (Depth First Search) of a Graph using only a visited array.
In this Program the answer array(ArrayList<Integer> ans) is the visited array declared and defined in the PerformDFS method.*/

import java.util.*;

public class Main {

    private static void DFS(ArrayList<ArrayList<Integer>> graph, int index, ArrayList<Integer> ans) {

        ans.add((index+1)); // Add the current node to the result array

        for(var neighbor: graph.get(index)){ // Check if the neighbor has not been visited

            if(!ans.contains(neighbor)){
                DFS(graph,neighbor-1,ans); // Recursively perform DFS on the unvisited neighbor, point to be noted here that neighbors have the actual VertixNumber+1 as their vertix number stored in the neighbor list of the main graph
            }
        }
    }

    private static ArrayList<Integer> PerformDFS(ArrayList<ArrayList<Integer>> graph) {
        ArrayList<Integer> ans = new ArrayList<>(); // Create a array using Arraylist to store the DFS triversal
        DFS(graph,0,ans); // Start DFS traversal from the first vertex (index 0)
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices and number of edges (separate them using a space like: V E): ");
        int v = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(v);

        // Initialize the ArrayList for each vertex
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
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

        // Output: DFS traversal of the graph
        System.out.println("DFS traversal of the graph: "+PerformDFS(graph));
        sc.close();
    }
}