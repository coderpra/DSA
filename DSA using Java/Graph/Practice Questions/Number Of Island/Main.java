import java.util.*;

public class Main {

    private static ArrayList<ArrayList<Integer>> stringToGraph(ArrayList<ArrayList<String>> twoDstring) {
        int rows = twoDstring.size();
        int cols = twoDstring.get(0).size();
        int noOfLands = 0;

        ArrayList<ArrayList<Integer>> inputArray = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            inputArray.add(new ArrayList<>());
            for (int j = 0; j < cols; j++) {
                if (twoDstring.get(i).get(j).equals("1")) {
                    inputArray.get(i).add(++noOfLands);
                } else if (twoDstring.get(i).get(j).equals("0")) {
                    inputArray.get(i).add(0);
                } else {
                    continue;
                }
            }
        }

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(noOfLands);

        // Initialize the graph with empty lists
        for (int i = 0; i < noOfLands; i++) {
            graph.add(new ArrayList<>());
        }

        int size = inputArray.size();
        int currentValue=0, check=0;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Build the graph based on island connections
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < inputArray.get(i).size(); j++) {
                currentValue = inputArray.get(i).get(j);

                if (currentValue > 0) {
                    currentValue--;
                    // Check neighbors in all eight directions
                    for (int k = 0; k < 8; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];

                        if (ni >= 0 && ni < size && nj >= 0 && nj < inputArray.get(i).size()) {
                            check = inputArray.get(ni).get(nj); //storing neighbours to check if they are eligable to be called as linked land
                            if (check > 0){
                                check--;
                                if(!(graph.get(currentValue).contains(check))) {
                                   graph.get(currentValue).add(check);
                                   graph.get(check).add(currentValue);
                                }
                            }
                        }
                    }
                }
            }
        }

        return graph;
    }

    private static void DFS(ArrayList<ArrayList<Integer>> graph, int index, ArrayList<Integer> visited) {
        visited.set(index, 1);
        for (var neighbor : graph.get(index)) {
            if (visited.get(neighbor) != 1) {
                DFS(graph, neighbor, visited);
            }
        }
    }

    private static int countIslands(ArrayList<ArrayList<Integer>> graph) {
        int size = graph.size();
        ArrayList<Integer> visited = new ArrayList<>(size);
        for (int i = 0; i < size; i++) visited.add(0);
        int islands = 0;
        for (int i = 0; i < size; i++) {
            if (visited.get(i) != 1) {
                DFS(graph, i, visited);
                islands++;
            }
        }
        return islands;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input in the form of a 2D array
        String str1 = sc.nextLine();
        sc.close();
        str1 = str1.substring(2, (str1.length() - 2)); // Omitting the first and last 2 [ , ]

        ArrayList<ArrayList<String>> twoDstring = new ArrayList<>();
        for (var blocks : str1.split("\\],\\[")) {
            twoDstring.add(new ArrayList<>(Arrays.asList(blocks.split(","))));
        }

        ArrayList<ArrayList<Integer>> graph = stringToGraph(twoDstring);
        int islandCount = countIslands(graph);

        System.out.println(islandCount);
    }
}
