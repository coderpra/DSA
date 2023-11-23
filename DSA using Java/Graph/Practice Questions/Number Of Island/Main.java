import java.util.*;

/**
 * This program calculates the number of connected islands in a 2D array.
 * Each island is represented by the value '1', and connected islands share the same number.
 */
class Main {

    
    private static void DFS(ArrayList<ArrayList<Integer>> graph, int index, ArrayList<Integer> visited) {
        // Check if the index is out of bounds
        if (index < 0 || index >= visited.size()) {
            return;
        }

        visited.set(index, 1);

        for (var neighbor : graph.get(index)) {
            // Check if the neighbor is within bounds and has not been visited
            if (neighbor >= 0 && neighbor < visited.size() && visited.get(neighbor) != 1) {
                DFS(graph, neighbor, visited);
            }
        }
    }

    
    private static int FindConnectedIslands(ArrayList<ArrayList<Integer>> graph) {
        int size = graph.size();
        ArrayList<Integer> visited = new ArrayList<>(size);

        // Initialize the visited list to mark unvisited islands
        for (int i = 0; i < size; i++) {
            visited.add(0);
        }

        int connectedIslands = 0;

        // Explore islands until all of them are visited
        while (visited.contains(0)) {
            DFS(graph, visited.indexOf(0), visited);
            connectedIslands++;
        }

        return connectedIslands;
    }

   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input in the form of a 2D array
        String str1 = sc.nextLine();
        String str2 = str1.substring(1, (str1.length() - 1)); // Omitting the first and last { , }
        String[] input = str2.split("\\},\\{");
        int size = input.length;

        // Create a 2D array to represent islands and assign unique numbers to them
        ArrayList<ArrayList<Integer>> inputArray = new ArrayList<>(size);
        int noOfIslands = 1; 

        for (var block : input) {
            ArrayList<Integer> row = new ArrayList<>();
            char[] chars = block.toCharArray();

            // Assign numbers to islands based on '1' and '0'
            for (var x : chars) {
                if (x == '0') {
                    row.add(0);
                } else if (x == '1') {
                    row.add(noOfIslands++);
                }
            }

            inputArray.add(row);
        }
        
        // Create a graph to represent connections between islands
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>((noOfIslands-1));

        // Initialize the graph with empty adjacency lists
        for (int i = 0; i < (noOfIslands-1); i++) {
            graph.add(new ArrayList<>());
        }

        int check, currentValue;

        // Build the graph based on island connections
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < inputArray.get(i).size(); j++) {
                currentValue = inputArray.get(i).get(j);

                if (currentValue > 0) {
                    // Check y-1 line
                    if (i != 0) {

                        // Add x,y-1
                        check = inputArray.get(i - 1).get(j);
                        if (check > 0 && !(graph.get(currentValue - 1).contains(check - 1))) {
                            graph.get(currentValue - 1).add(check - 1);
                            graph.get(check - 1).add(currentValue - 1);
                        }

                        // Add x-1,y-1
                        if (j != 0) {
                            check = inputArray.get(i - 1).get(j - 1);
                            if (check > 0 && !(graph.get(currentValue - 1).contains(check - 1))) {
                                graph.get(currentValue - 1).add(check - 1);
                                graph.get(check - 1).add(currentValue - 1);
                            }
                        }

                        // Add x+1,y-1
                        if (j != (inputArray.get(i).size()) - 1) {
                            check = inputArray.get(i - 1).get(j + 1);
                            if (check > 0 && !(graph.get(currentValue - 1).contains(check - 1))) {
                                graph.get(currentValue - 1).add(check - 1);
                                graph.get(check - 1).add(currentValue - 1);
                            }
                        }
                    }

                    // Add x+1,y
                    if (j != (inputArray.get(i).size()) - 1) {
                        check = inputArray.get(i).get(j + 1);
                        if (check > 0 && !(graph.get(currentValue - 1).contains(check - 1))) {
                            graph.get(currentValue - 1).add(check - 1);
                            graph.get(check - 1).add(currentValue - 1);
                        }
                    }

                    // Add x-1,y
                    if (j != 0) {
                        check = inputArray.get(i).get(j - 1);
                        if (check > 0 && !(graph.get(currentValue - 1).contains(check - 1))) {
                            graph.get(currentValue - 1).add(check - 1);
                            graph.get(check - 1).add(currentValue - 1);
                        }
                    }

                    // Add y+1 line
                    if (i != size - 1) {
                        // Add x,y+1
                        check = inputArray.get(i + 1).get(j);
                        if (check > 0 && !(graph.get(currentValue - 1).contains(check - 1))) {
                            graph.get(currentValue - 1).add(check - 1);
                            graph.get(check - 1).add(currentValue - 1);
                        }

                        // Add x-1,y+1
                        if (j != 0) {
                            check = inputArray.get(i + 1).get(j - 1);
                            if (check > 0 && !(graph.get(currentValue - 1).contains(check - 1))) {
                                graph.get(currentValue - 1).add(check - 1);
                                graph.get(check - 1).add(currentValue - 1);
                            }
                        }

                        // Add x+1,y+1
                        if (j != (inputArray.get(i).size()) - 1) {
                            check = inputArray.get(i + 1).get(j + 1);
                            if (check > 0 && !(graph.get(currentValue - 1).contains(check - 1))) {
                                graph.get(currentValue - 1).add(check - 1);
                                graph.get(check - 1).add(currentValue - 1);
                            }
                        }
                    }
                }
            }
        }

        System.out.println(FindConnectedIslands(graph));
       
    }
}
