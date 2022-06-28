package programmingForDevelopers.n_day20Graph.e_greedyApproach;

public class ShortestPathBellManFord {
    int vertices;
    int[][] matrix;

    ShortestPathBellManFord(int vertices) {
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
    }

    public void addEdge(int source, int destination, int weight) {
        matrix[source][destination] = weight;
    }

    public void printGraph() {
        //travelling to rows
        for (int i = 0; i < vertices; i++) {
            //travelling to columns
            for (int j = 0; j < vertices; j++) {
                //printing values of matrix
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public void dijkstra(int source, int destination) {

        int[] distance = new int[vertices];
        int[] prevPath = new int[vertices];

        //Initially updating distance to infinity
        //and updating prevPath to -1
        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
            prevPath[i] = -1;
        }
        //Distance from source to source is zero
        distance[source] = 0;


        // Identify cycle.
        int numChange = 0;

        for(int k = 0; k < vertices-1; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (matrix[i][j] != 0) {
                        int newDistance = distance[i] + matrix[i][j];
                        if (newDistance < distance[j]) {
                            distance[j] = newDistance;
                            prevPath[j] = i;
                            numChange ++;
                        }
                    }
                }
            }
        }

        //Printing distance
        System.out.println("\nShortest distance from source(" + source + ") to destination(" + destination + ") is : " + distance[destination]);


        if(numChange >= vertices){
            System.out.println("\nThere exists a cycle. "  + numChange);
        }

        //Printing the shortest path

        int[] shortestPath = new int[vertices];
        int vertex = destination;
        int count = 0;
        
        while (vertex != -1){
            shortestPath[count] = vertex;
            vertex = prevPath[vertex];
            count++;
        }
        
        System.out.print("\nShortest path is : ");
        for (int i = count -1;  i>=0; i--){
            System.out.print(shortestPath[i] + " , ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ShortestPathBellManFord g = new ShortestPathBellManFord(6);
        g.addEdge(0, 1, 10);
        g.addEdge(0, 2, 5);
        g.addEdge(0, 5, 100);
        g.addEdge(1, 3, 20);
        g.addEdge(1, 2, 30);
        g.addEdge(2, 4, 10);
        g.addEdge(3, 4, 5);
        g.addEdge(3, 5, 15);
        g.addEdge(4, 5, 15);

        System.out.println(" ");
        g.printGraph();


        g.dijkstra(0, 5);

    }


}
