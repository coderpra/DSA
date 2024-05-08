import java.util.*;

// Class representing a node in the doubly linked list
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

// Class representing the doubly linked list
class DoublyLinkedList {
    private Node head;
    public int nodes;

    public DoublyLinkedList() {
        this.head = null;
        this.nodes = 0;
    }

    // Method to add a node at the beginning of the list
    public void addAtBeginning(int d) {
        Node newNode = new Node(d);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        nodes++;
    }

    // Method to add a node at the end of the list
    public void addAtEnd(int d) {
        Node newNode = new Node(d);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
        nodes++;
    }

    // Method to add a node at a specific position in the list
    public void addAtPosition(int d, int position) {
        if (position < 1 || position > nodes + 1) {
            System.out.println("Invalid position. Node cannot be added.");
            return;
        }
        if (position == 1) {
            addAtBeginning(d);
        } else if (position == nodes + 1) {
            addAtEnd(d);
        } else {
            Node newNode = new Node(d);
            Node current = head;
            for (int i = 1; i < position - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next.prev = newNode;
            current.next = newNode;
            newNode.prev = current;
            nodes++;
        }
    }

    // Method to delete a node at the beginning of the list
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty. No node to delete.");
            return;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        nodes--;
    }

    // Method to delete a node at the end of the list
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty. No node to delete.");
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        nodes--;
    }

    // Method to delete a node at a specific position in the list
    public void deleteAtPosition(int position) {
        if (position < 1 || position > nodes) {
            System.out.println("Invalid position. Node cannot be deleted.");
            return;
        }
        if (position == 1) {
            deleteAtBeginning();
        } else if (position == nodes) {
            deleteAtEnd();
        } else {
            Node current = head;
            for (int i = 1; i < position; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            nodes--;
        }
    }

    // Method to print the doubly linked list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to search for a node by value
    public boolean searchByValue(int value) {
        if (head == null) {
            System.out.println("List is empty. No node to search.");
            return false;
        }
        Node current = head;
        int position = 1;
        while (current != null) {
            if (current.data == value) {
                System.out.println("Node with value " + value + " found at position " + position);
                return true;
            }
            current = current.next;
            position++;
        }
        System.out.println("Node with value " + value + " not found.");
        return false;
    }

    // Method to search for a node by position
    public int searchByPosition(int position) {
        if (position < 1 || position > nodes) {
            System.out.println("Invalid position. No node found.");
            return -1;
        }
        Node current = head;
        for (int i = 1; i < position; i++) {
            current = current.next;
        }
        System.out.println("Node at position " + position + " has value: " + current.data);
        return current.data;
    }
}

// Main class
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList dll = new DoublyLinkedList();
        int choice, data, position;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add node");
            System.out.println("2. Delete node");
            System.out.println("3. Search node");
            System.out.println("4. Print list");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nChoose where to add the node:");
                    System.out.println("1. Beginning");
                    System.out.println("2. End");
                    System.out.println("3. Specific Position");
                    System.out.print("Enter your choice: ");
                    int addChoice = sc.nextInt();
                    System.out.print("Enter the data to add: ");
                    data = sc.nextInt();
                    if (addChoice == 1) {
                        dll.addAtBeginning(data);
                    } else if (addChoice == 2) {
                        dll.addAtEnd(data);
                    } else if (addChoice == 3) {
                        System.out.print("Enter the position to add the node: ");
                        position = sc.nextInt();
                        dll.addAtPosition(data, position);
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;
                case 2:
                    if (dll.nodes == 0) {
                        System.out.println("List is empty. No node to delete.");
                    } else {
                        System.out.println("\nChoose where to delete the node:");
                        System.out.println("1. Beginning");
                        System.out.println("2. End");
                        System.out.println("3. Specific Position");
                        System.out.print("Enter your choice: ");
                        int deleteChoice = sc.nextInt();
                        if (deleteChoice == 1) {
                            dll.deleteAtBeginning();
                        } else if (deleteChoice == 2) {
                            dll.deleteAtEnd();
                        } else if (deleteChoice == 3) {
                            System.out.print("Enter the position to delete the node: ");
                            position = sc.nextInt();
                            dll.deleteAtPosition(position);
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("\nChoose how to search for the node:");
                    System.out.println("1. Search by value");
                    System.out.println("2. Search by position");
                    System.out.print("Enter your choice: ");
                    int searchChoice = sc.nextInt();
                    if (searchChoice == 1) {
                        System.out.print("Enter the value to search for: ");
                        data = sc.nextInt();
                        dll.searchByValue(data);
                    } else if (searchChoice == 2) {
                        System.out.print("Enter the position to search for: ");
                        position = sc.nextInt();
                        dll.searchByPosition(position);
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;
                case 4:
                    System.out.println("\nCurrent list:");
                    dll.printList();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}
