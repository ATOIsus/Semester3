package programmingForDevelopers.n_day20Graph.e_greedyApproach.shortestPathUndirectedGrapg;

public class UsingMatrix {

    int vertices;
    int[][] matrix;

    UsingMatrix(int vertices) {
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
    }

    public void addEdge(int source, int destination) {
        matrix[source][destination] = 1;
        matrix[destination][source] = 1;
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



    void shortestPath(int source, int destination){
        boolean visited[] = new boolean[vertices];
        QueueEg que = new QueueEg(vertices);

        int distance[] = new int[vertices];
        int prevPath[] = new int [vertices];

        for(int i =0; i<vertices; i++){
            distance[i] = Integer.MAX_VALUE;
            prevPath[i] = -1;
        }

        distance[source] = 0;

        que.enqueue(source);
        visited[source] = true;

        while(!que.isEmpty()){
            int u = que.dequeue();

            for(int i=0; i<vertices; i++){
                int v =-1;
                if(matrix[u][i] != 0 && !visited[i]){
                    v = i;
                    int newDistance = distance[u] + 1;
                    if(newDistance < distance[v]){
                        distance[v] = newDistance;
                        prevPath[v] = u;


                        que.enqueue(v);
                        visited[v] = true;
                    }
                }
            }
        }

        //Printing distance
        System.out.println("\nShortest distance from source(" + source + ") to destination(" + destination + ") is : " + distance[destination]);

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
        UsingMatrix obj = new UsingMatrix(6);
        obj.addEdge(0 ,1);
        obj.addEdge(0 ,2);
        obj.addEdge(1 ,2);
        obj.addEdge(1 ,3);
        obj.addEdge(2 ,3);
        obj.addEdge(2 ,4);
        obj.addEdge(2 ,5);
        obj.addEdge(3 ,4);
        obj.addEdge(3 ,5);
        obj.addEdge(4 ,5);

        obj.shortestPath(0,5);


    }
}
