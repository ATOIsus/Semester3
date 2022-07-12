package programmingForDevelopers.o_Tree;

public class BinarySearchTree {

    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }

    public Node createBST(int data, Node rootnode){
        if(rootnode==null){

          return  new Node(data);
        }
        if(data<rootnode.data){
            return rootnode.left=createBST(data,rootnode.left);
        }
        else{
            return  rootnode.right=createBST(data,rootnode.right);
        }

    }

    public boolean searchElement(int data, Node rootnode){
      if(data==rootnode.data){
          return true;
      }
      if(data<rootnode.data){
          return searchElement(data,rootnode.left);
      }
      else{
          return searchElement(data,rootnode.right);
      }
    }

    public void removeNode(int data){




    }
}
