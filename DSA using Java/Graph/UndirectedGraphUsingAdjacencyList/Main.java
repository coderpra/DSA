/*Java Program to create a undirected graph using Adcacency List */
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
   public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices and number of edges (separate them using a space like: V E): ");
        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(vertices);

        // Initialize the ArrayList for each vertex
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges; i++) {
            System.out.print("Enter the two vertices connected with an undirected edge (separate them using a space like: V1 V2): ");
            int Vertix2 = sc.nextInt();
            int Vertix1 = sc.nextInt();

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
        int f = 1;
        while (f != 0) {
            System.out.println("\t\t\t\t\tTo know which vertices are connected to a specific vertex, enter 1.");
            System.out.println("\t\t\t\t\tTo stop, enter 2.");
            System.out.print("Enter: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter vertex number: ");
                    int vn = sc.nextInt();
                    if(vn>graph.size()){
                     System.out.println("Vertix "+vn+"doesn't exist in the graph!!");
                     break;
                    }
                    // Display vertices connected to the specified vertex
                    if (graph.get(vn - 1).size() != 0){
                     System.out.println("Vertex " + vn + " is connected with undirectly vertices,");
                     for (var x : graph.get(vn-1)) {
                            System.out.println("\t\t\t\t\t\t\t\t\t\t"+ x);
                    }
                    System.out.println("These are all connected with vertex " + vn+".");}
                    else{
                     System.out.println("Vertix "+vn+" have no connection with any vertices in the graph.");
                    }
                    break;

                case 2:
                    // Exit the loop
                    f=0;
                    break;

                default:
                    System.out.println("Enter only 1 and 2!");
            }
        }
        sc.close();
    }
   }
