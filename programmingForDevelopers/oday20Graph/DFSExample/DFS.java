package programmingForDevelopers.oday20Graph.DFSExample;



public class DFS {


    LinkedListExample1[] a;
    int vertices;

    DFS(int vertices) {
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

    public int [] getAdjacentNode(int i){
        int list[]=new int[a[i].getSize()];
        LinkedListExample1.Node current=a[i].head;
        int indx=0;
        while(current!=null){
            list[indx++]= current.data;
            current=current.next;
        }
        return list;
    }







}
