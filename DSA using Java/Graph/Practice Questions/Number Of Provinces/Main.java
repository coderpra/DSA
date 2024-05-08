/*Given an undirected graph with V vertices. We say two vertices u and v belong to a single province if there is a path from u to v or v to u. Your task is to find the number of provinces.

Note: A province is a group of directly or indirectly connected cities and no other cities outside of the group 

Input:
[
 [1, 0, 1],  -->pos 0 is 1 and pos 2 is 1 it means 0th vertix is connected with 2nd numbered vertex
 [0, 1, 0],  -->only pos 1 is 1 it means 1th number vertex is not connected with 0th or 2nd number vertix because they are marked as 0
 [1, 0, 1]   -->pos 0 is 1 and pos 2 is 1 it means 0th vertix is connected with 2nd numbered vertex
]

Output:
2
Explanation:
The graph clearly has 2 Provinces [1,3] and [2]. As city 1 and city 3 has a path between them they belong to a single province. City 2 has no path to city 1 or city 3 hence it belongs to another province*/

import java.util.*;
public class Main {
    private static void DFS(ArrayList<ArrayList<Integer>> graph, int index, ArrayList<Integer> visited) {

        visited.set(index,1);
        for(var neighbor: graph.get(index)){ // Check if the neighbor has not been visited
            neighbor--;
            if(visited.get(neighbor)!=1){
                DFS(graph,neighbor,visited); // Recursively perform DFS on the unvisited neighbor
            }
        }
    }

    private static int FindProvinces(ArrayList<ArrayList<Integer>> graph){
        int size=graph.size();
        ArrayList<Integer> visited= new ArrayList<>(size);
        for (int i = 0; i < size; i++) visited.add(0);
        int provinces=0;
        while(visited.contains(0)){
            DFS(graph,visited.indexOf(0),visited);
            provinces++;
        }
        return provinces;
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

        //number of provinces print
        System.out.println("Output:");
        System.out.println(FindProvinces(graph));
        sc.close();
    }
}
