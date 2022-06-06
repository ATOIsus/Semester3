package programmingForDevelopers.day20Graph;

public class GraphExample {
    int vertices;
    int matrix[][];

    GraphExample(int vertices) {
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
            System.out.println("");
        }
    }

    public void printAdjEdges() {
        //travelling to rows
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " is connected to: ");
            for (int j = 0; j < vertices; j++) {
                if (matrix[i][j] != 0) {
                    System.out.print(j + ", ");
                }
            }
            System.out.println("");
        }
    }

    public int[] getAdjNode(int i) {
        //travelling to rows
        int pos = 0;
        int[] adjNode = new int[vertices];
        for (int k = 0; k < adjNode.length; k++) {
            adjNode[k] = -999;
        }


        for (int j = 0; j < vertices; j++) {
            if (matrix[i][j] != 0) {
                adjNode[pos] = j;
                pos++;
            }
        }

        return adjNode;
    }

    public Node getAdjLinkedList(int i) {
        for (int j = 0; j < vertices; j++) {
            if (matrix[i][j] != 0) {
                addNode(j);
            }
        }
        return head;
    }


    public static class Node {
        int data;
        GraphExample.Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    GraphExample.Node head = null;
    GraphExample.Node tail = null;

    public void addNode(int data) {
        GraphExample.Node newnode = new GraphExample.Node(data);
        if (head == null) {
            head = tail = newnode;
        } else {
            tail.next = newnode;
            tail = newnode;
        }
    }


    public static void main(String[] args) {
        GraphExample g = new GraphExample(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        System.out.println(" ");
        g.printGraph();

        System.out.println();
        g.printAdjEdges();

        System.out.println();
        int[] res = g.getAdjNode(1);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

        System.out.println();
        Node res1 = g.getAdjLinkedList(2);
        while (res1 != null) {
            System.out.print(res1.data + " ");
            res1 = res1.next;
        }
    }

}
