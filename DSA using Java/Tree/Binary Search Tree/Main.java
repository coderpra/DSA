import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BST{
    public Node root = null;
    
    public BST(int data){
        root = new Node(data);
    }

    public static addNode(int data){
        addNode(data, root);
    }

    private static addNode(int data,Node root){
        if(root==null) {
            root=new Node(data);
            return;
        }

        if(data==root.data){
            System.out.println("data already exists enter new data.");
        }else if(data<root.data){
            addNode(data,root.left);
        }else{
            addNode(data,root.right);
        }
    }

}
public class Main {

    
}
