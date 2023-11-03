import java.util.*;

class Node {
    public int data;
    public Node prev;
    public Node next;

    Node(int d) {
        this.data = d;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkList {
    private Node head;
    public int nodes;

    public DoublyLinkList() {
        this.head = null;
        this.nodes = 0;
    }

    public void addNode(int d, int givenPos) {
        Node newNode = new Node(d);
        // for addition at first position
        if (head == null || givenPos == 1) {
            if (head != null) {
                head.prev = newNode;
                newNode.next = head;
            }
            if (givenPos > 1) {
                System.out.println("The link-list is empty!\nSo it doesn't have position " + givenPos
                        + ", so the new node is added at the end.");
            }
            head = newNode;
            nodes++;
            return;
        }
        // for insertion at end
        Node current = head;
        if (givenPos == 0 || givenPos > nodes) {
            if (givenPos > nodes + 1)
                System.out.println("Link-list is shorter to have the position " + givenPos
                        + ", so the new node is added at the end.");
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
            nodes++;
            return;

        }
        // insertion at anyposition
        for (int currentPos = 1; currentPos < givenPos; currentPos++, current = current.next)
            ;
        newNode.next = current;
        newNode.prev = current.prev;
        current.prev.next = newNode;
        current.prev = newNode;
        nodes++;
    }

    public boolean deleteNode(int givenPos) {
        if (head == null || givenPos > nodes) {
            if (head == null)
                System.out.println("Link-List is empty!!");
            if (givenPos > nodes)
                System.out
                        .println("Given position have acceded the range(from 1 to " + nodes + ") of the link-list!! ");
            return false;
        }
        Node current = head;
        if (givenPos == 1 || (head.next == null && givenPos == 0)) {
            head = head.next;
            if (head != null)
                head.prev = null;
            nodes--;
        } else if (givenPos == 0 || (givenPos != 1 && givenPos == nodes)) {
            while (current.next != null) {
                current = current.next;
            }
            current.prev.next = null;
            current.prev = null;
            nodes--;
        } else {
            for (int currentPos = 1; currentPos < givenPos; currentPos++, current = current.next)
                ;
            current.next.prev = current.prev;
            current.prev.next = current.next;
            current.next = null;
            current.prev = null;
            nodes--;
        }
        return true;
    }

    public void printLinklist() {
        if (head == null) {
            System.out.println("LinkList is empty!!");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null)
                System.out.print("<==>");
            current = current.next;
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkList dl = new DoublyLinkList();
        int choice = 0, position = 0, data = 0;
        while (true) {
            System.out.print(
                    "Enter 1 to create a node.\nEnter 2 to delete a node.\nEnter 3 to print the linklist.\nEnter 4 to stop.\nEnter : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print(
                            "Enter the position where you wanna insert the data (1 for insert at beggining, 0 for at end and any integer number for random position)\nYou can Enter Between 0 to "
                                    + (dl.nodes + 1) + "\nEnter : ");
                    position = sc.nextInt();
                    System.out.print("Enter a integer data : ");
                    data = sc.nextInt();
                    dl.addNode(data, position);
                    break;
                case 2:
                    if (dl.nodes > 0) {
                        System.out.print(
                                "Enter the position that you wanna delete a data (1 for insert at beggining, 0 for at end and any integer number for random position)\nYou can Enter Between 0 to "
                                        + dl.nodes + " .\nEnter : ");
                        position = sc.nextInt();
                    } else
                        position = 0;
                    dl.deleteNode(position);
                    break;
                case 3:
                    dl.printLinklist();
                    break;
                case 4:
                    System.out.println("Bye Bye!!");
                    sc.close();
                    return;
                default:
                    System.out.print("Insert Correctly from 1 to 4!!\n");
            }
        }
    }
}
