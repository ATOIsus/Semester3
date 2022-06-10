package programmingForDevelopers.oday20Graph.BFSExample;


public class BFSExample {

    LinkedListEg[] a;
    int vertices;

    BFSExample(int vertices) {
        this.vertices = vertices;
        a = new LinkedListEg[vertices];
        for (int i = 0; i < vertices; i++) {
            a[i] = new LinkedListEg();
        }
    }

    public void addEdge(int source, int destination) {
        a[source].addNode(destination);
        a[destination].addNode(source);
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " is connected to: ");
            a[i].getList();
            System.out.println();
        }
    }

    public void BFS(int rootnode) {
        System.out.println("Exploring element with BFS algorithm with rootNode : " + rootnode);
        boolean visited[] = new boolean[vertices];
        QueueEg q = new QueueEg(vertices);
        visited[rootnode] = true;
        q.enqueue(rootnode);
        while (!q.isEmpty()) {
            int x = q.dequeue();
            int[] list = getAdjacentNode(x);
            for (int i = 0; i < list.length; i++) {
                int adjNode = list[i];
                if (!visited[adjNode]) {
                    q.enqueue(adjNode);
                    visited[adjNode] = true;
                }
            }
            System.out.println("Element visited : " + x);
        }
    }

    public int[] getAdjacentNode(int i) {
        int list[] = new int[a[i].getSize()];
        LinkedListEg.Node current = a[i].head;
        int indx = 0;
        while (current != null) {
            list[indx++] = current.data;
            current = current.next;
        }
        return list;
    }

    /*

    public void BFSEGGG(int rootNode){
        boolean visited[] = new boolean[vertices];
        QueueEg queue = new QueueEg(vertices);

        visited[rootNode] = true;

        queue.enqueue(rootNode);

        while (!queue.isEmpty()){
            int x = queue.dequeue();
            int[] listAdjacent = getAdjacentNode(x);

            for (int i = 0; i < listAdjacent.length; i ++){
                int adjNode = listAdjacent[i];

                if (!visited[adjNode]){
                    queue.enqueue(adjNode);
                    visited[adjNode] = true;
                }
            }
            System.out.println("Node visited: " + x);
        }
    }
     */


    public static void main(String[] args) {
        BFSExample g = new BFSExample(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.printGraph();
        System.out.println();

        g.BFS(1);



    /*
        System.out.println();
        int vertex = 4;
        int[] res =  g.getAdjacentNode(vertex);
        System.out.print("Adjacent Node of " + vertex + " is : ");
        for (int i = 0; i < res.length; i++){
            System.out.print(res[i] + " , ");
        }
        System.out.println("\n");

        g.BFSEGGG(1);
    */


    }

}
