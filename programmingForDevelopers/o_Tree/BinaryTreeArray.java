package programmingForDevelopers.o_Tree;

public class BinaryTreeArray {

    int size;
    int[] arrayBinary;

    BinaryTreeArray(int size){
        this.size = size;
        this.arrayBinary = new int [size];

        for (int i = 0; i < size; i++){
            arrayBinary[i] = Integer.MIN_VALUE;
        }
    }

    public void arrayRepresent(int parent, int child){

        // Find Parent index
        int parentIndex = -1;
        for(int i = 0; i < size; i++){
            if (arrayBinary[i] == parent){
                parentIndex = i;
                break;
            }
        }

        int leftChild = parentIndex * 2  + 1;
        int rightChild = leftChild + 1;

        // If this is the root node. i.e. it has no parent.
        if(parentIndex == -1) {
            arrayBinary[0] = child;
            return;
        }

        // Check if the leftChild or rightChild is assigned or not.
        if(arrayBinary[leftChild] == Integer.MIN_VALUE){
            arrayBinary[leftChild] = child;
        }else if(arrayBinary[rightChild] == Integer.MIN_VALUE){
            arrayBinary[rightChild] = child;
        }else{
            System.out.println("The parent " + parent + " node already has 2 child nodes!");
        }
    }

    public void printGraph(int parentIndex){

        int leftChild = parentIndex * 2  + 1;
        int rightChild = leftChild + 1;

        if(parentIndex >= size || leftChild >= size  || rightChild >= size){
            return;
        }

        System.out.println(arrayBinary[parentIndex] + " : " + arrayBinary[leftChild] + " , " + arrayBinary[rightChild]);

        printGraph(leftChild);
        printGraph(rightChild);

    }


    public static void main(String[] args) {

        System.out.println("\nThe size of the array must be odd and the node(value) cannot be repeated! \n");

        BinaryTreeArray obj = new BinaryTreeArray(7);

        // Root node.
        obj.arrayRepresent(1,1);

        obj.arrayRepresent(1,2);
        obj.arrayRepresent(1,3);

        obj.arrayRepresent(2,4);
        obj.arrayRepresent(2,5);

        obj.arrayRepresent(3,6);
        obj.arrayRepresent(3,7);


        obj.printGraph(0);


    }

}
