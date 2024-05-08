/*Java Program to create a undirected graph using Adcacency Matrix */
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices and number of edges (separate them using a space like: V E): ");
        int v = sc.nextInt();
        int e = sc.nextInt();

        // Create an adjacency matrix
        int[][] matrix = new int[v][v];

        // Input edges
        for (int i = 0; i < e; i++) {
            System.out.print("Enter the two vertices connected with an undirected edge (separate them using a space like: V1 V2): ");
            int e1 = sc.nextInt();
            int e2 = sc.nextInt();

            // Check if edge already exists
            if (matrix[e1 - 1][e2 - 1] == 1) {
                i--;
                System.out.print("Edge already exists.\n Please Again, ");
                continue;
            }

            // Update the adjacency matrix for an undirected graph
            matrix[e1 - 1][e2 - 1] = 1;
            matrix[e2 - 1][e1 - 1] = 1;
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

                    // Display vertices connected to the specified vertex
                    for (int j = 0; j < v; j++) {
                        if (matrix[vn - 1][j] == 1) {
                            System.out.println("Vertex " + vn + " is connected with vertex " + (j + 1) + " using an undirected edge.");
                        }
                    }
                    System.out.println("These are all connected with vertex " + vn+".");
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
