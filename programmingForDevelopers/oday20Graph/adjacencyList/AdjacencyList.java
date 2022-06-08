package programmingForDevelopers.oday20Graph.adjacencyList;

public class AdjacencyList {

    LinkedListExample1[] a;
    int vertices;

    AdjacencyList(int vertices) {
        this.vertices = vertices;
        a = new LinkedListExample1[vertices];
        for (int i = 0; i < vertices; i++) {
            a[i] = new LinkedListExample1();
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

    public LinkedListExample1.Node getAdjacentNode(int i) {
        return a[i].returnAdjacentNode();
    }


    public static void main(String[] args) {
        AdjacencyList g = new AdjacencyList(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.printGraph();


        System.out.println();
        LinkedListExample1.Node current = g.getAdjacentNode(1);;
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
            System.out.print( " , ");
        }

    }
}
