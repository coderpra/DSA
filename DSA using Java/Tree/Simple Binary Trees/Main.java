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

class BT {
    public static Node createTree() {
        Scanner sc = new Scanner(System.in);
        Node root = null;
        System.out.print(" : ");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        root = new Node(data);
        System.out.print("Do you want to enter the left child of " + data + " [enter only as per your choice y/n] : ");
        char choice1 = sc.next().charAt(0);

        if (choice1 == 'y' || choice1 == 'Y') {
            System.out.print("Enter left child of " + data);
            root.left = createTree();
        }

        System.out.print("Do you want to enter the right child of " + data + " [enter only as per your choice y/n] : ");
        char choice2 = sc.next().charAt(0);
        sc.close();

        if (choice2 == 'y' || choice2 == 'Y') {
            System.out.print("Enter right child of " + data);
            root.right = createTree();
        }

        return root;
    }

    public static void printInOrder(Node root) {
    if (root == null) return;

    printInOrder(root.left);
    System.out.print(root.data + ", ");
    printInOrder(root.right);
}

    public static void printPreOrder(Node root) {
    if (root == null) return;

    System.out.print(root.data + ", ");
    printPreOrder(root.left);
    printPreOrder(root.right);
    }

    public static void printPostOrder(Node root) {
    if (root == null) return;

    printPostOrder(root.left);
    printPostOrder(root.right);
    System.out.print(root.data + ", ");
    }

    
}

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter root data ");
        Node root = BT.createTree();
        System.out.print("In-order triversal of the Binary tree is : ");
        BT.printInOrder(root);
        System.out.println();

        System.out.print("Pre-order triversal of the Binary tree is : ");
        BT.printPreOrder(root);
        System.out.println();

        System.out.print("Post-order triversal of the Binary tree is : ");
        BT.printPostOrder(root);
        System.out.println();
    }
}
