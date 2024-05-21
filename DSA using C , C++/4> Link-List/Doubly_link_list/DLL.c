#include <stdio.h>
#include <stdlib.h>

// Structure representing a node in the doubly linked list
struct Node {
    int data;
    struct Node *prev;
    struct Node *next;
};

// Structure representing the doubly linked list
struct DoublyLinkedList {
    struct Node *head;
    struct Node *tail;
};

// Global variables
int linkListExists = 0; // Flag to track if the linked list has been created (0 = Not created, 1 = Created)
int size = 0; // Size of the linked list

// Function prototypes
void createList(struct DoublyLinkedList *list);
void printList(struct DoublyLinkedList *list);
void addAtBeginning(struct DoublyLinkedList *list, int data);
void addAtEnd(struct DoublyLinkedList *list, int data);
void addAtPosition(struct DoublyLinkedList *list, int data, int position);
void deleteAtBeginning(struct DoublyLinkedList *list);
void deleteAtEnd(struct DoublyLinkedList *list);
void deleteAtPosition(struct DoublyLinkedList *list, int position);
int searchByValue(struct DoublyLinkedList *list, int value);
int searchByPosition(struct DoublyLinkedList *list, int position);
void deleteList(struct DoublyLinkedList *list);
void clearInputBuffer();

int main() {
    struct DoublyLinkedList list;
    list.head = list.tail = NULL;

    int choice, data, position;

    while (1) {
        printf("\nMenu:\n");
        printf("1. Add node\n");
        printf("2. Print list\n");
        printf("3. Delete node\n");
        printf("4. Search node\n");
        printf("5. End program\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);
        clearInputBuffer();

        switch (choice) {
            case 1:
                if (!linkListExists) {
                    createList(&list); // Automatically create list if not created
                    linkListExists = 1; // Set flag to indicate the existence of the linked list
                }
                printf("Enter the data to add: ");
                scanf("%d", &data);

                printf("Choose the position:\n");
                printf("1. Beginning\n");
                printf("2. End\n");
                printf("3. Specific Position\n");
                scanf("%d", &position);

                if (position == 1) {
                    addAtBeginning(&list, data);
                } else if (position == 2) {
                    addAtEnd(&list, data);
                } else if (position == 3) {
                    printf("Enter the position to add: ");
                    scanf("%d", &position);
                    addAtPosition(&list, data, position);
                } else {
                    printf("Wrong Input!!\n You have to enter between 1, 2, or 3\n");
                }
                break;
            case 2:
                printList(&list);
                break;
            case 3:
                printf("Choose the position to delete:\n");
                printf("1. Beginning\n");
                printf("2. End\n");
                printf("3. Specific Position\n");
                scanf("%d", &position);
                if (position == 1) {
                    deleteAtBeginning(&list);
                } else if (position == 2) {
                    deleteAtEnd(&list);
                } else if (position == 3) {
                    printf("Enter the position to delete: ");
                    scanf("%d", &position);
                    deleteAtPosition(&list, position);
                } else {
                    printf("Invalid position choice\n");
                }
                break;
            case 4:
                printf("Choose the search option:\n");
                printf("1. By Value\n");
                printf("2. By Position\n");
                scanf("%d", &choice);
                switch (choice) {
                    case 1:
                        printf("Enter the value to search for: ");
                        scanf("%d", &data);
                        position = searchByValue(&list, data);
                        if (position != -1) {
                            printf("Value found at position: %d\n", position);
                        } else {
                            printf("Value not found\n");
                        }
                        break;
                    case 2:
                        printf("Enter the position to search for: ");
                        scanf("%d", &position);
                        data = searchByPosition(&list, position);
                        if (data != -1) {
                            printf("Data at position %d: %d\n", position, data);
                        } else {
                            printf("Position out of bounds or list is empty\n");
                        }
                        break;
                    default:
                        printf("Invalid search option\n");
                }
                break;
            case 5:
                deleteList(&list);
                printf("Program ending...\n");
                exit(0);
            default:
                printf("Invalid choice\n");
        }
    }

    return 0;
}

// Function to create an empty doubly linked list
void createList(struct DoublyLinkedList *list) {
    list->head = list->tail = NULL;
    size = 0; // Reset the size to 0 when creating a new list
}

// Function to print the contents of the doubly linked list
void printList(struct DoublyLinkedList *list) {
    if (list->head == NULL) {
        printf("List is empty\n");
        return;
    }

    struct Node *temp = list->head;
    printf("List: ");
    while (temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

// Function to add a node at the beginning of the list
void addAtBeginning(struct DoublyLinkedList *list, int data) {
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node)); // Allocate memory for new node
    newNode->data = data;
    newNode->prev = NULL;

    if (list->head == NULL) {
        newNode->next = NULL; // Empty list, set next to NULL
        list->tail = newNode; // Set tail to the new node
    } else {
        newNode->next = list->head; // Set new node's next to current head
        list->head->prev = newNode; // Set current head's prev to new node
    }

    list->head = newNode; // Update head to the new node
    size++; // Increment size when a node is added
}

// Function to add a node at the end of the list
void addAtEnd(struct DoublyLinkedList *list, int data) {
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node)); // Allocate memory for new node
    newNode->data = data;
    newNode->next = NULL;

    if (list->head == NULL) {
        newNode->prev = NULL; // Empty list, set prev to NULL
        list->head = newNode; // Set head to the new node
    } else {
        list->tail->next = newNode; // Set current tail's next to new node
        newNode->prev = list->tail; // Set new node's prev to current tail
    }

    list->tail = newNode; // Update tail to the new node
    size++; // Increment size when a node is added
}

// Function to add a node at a specific position in the list
void addAtPosition(struct DoublyLinkedList *list, int data, int position) {
    if (position < 1 || position > size + 1) { // Check if the given position is valid
        printf("Invalid position\n");
        return;
    }

    if (position == 1) {
        addAtBeginning(list, data);
        return;
    } else if (position == size + 1) {
        addAtEnd(list, data);
        return;
    }

    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node)); // Allocate memory for new node
    newNode->data = data;

    int currentPosition = 1;
    struct Node *temp = list->head;

    while (currentPosition < position - 1) {
        temp = temp->next;
        currentPosition++;
    }

    newNode->next = temp->next;
    newNode->prev = temp;
    temp->next->prev = newNode;
    temp->next = newNode;
    size++; // Increment size when a node is added
}

// Function to delete the node at the beginning of the list
void deleteAtBeginning(struct DoublyLinkedList *list) {
    if (list->head == NULL) {
        printf("List is empty\n");
        return;
    }

    struct Node *temp = list->head;
    list->head = list->head->next;

    if (list->head != NULL) { // Not the last node
        list->head->prev = NULL;
    } else { // Last node, update tail as well
        list->tail = NULL;
    }

    free(temp); // Free the memory of the deleted node
    size--; // Decrement size when a node is deleted
}

// Function to delete the node at the end of the list
void deleteAtEnd(struct DoublyLinkedList *list) {
    if (list->head == NULL) {
        printf("List is empty\n");
        return;
    }

    if (list->head == list->tail) { // Only one node
        deleteAtBeginning(list);
        return;
    }

    struct Node *temp = list->tail->prev;
    temp->next = NULL;
    list->tail = temp;

    free(list->tail->next); // Free the memory of the deleted node
    size--; // Decrement size when a node is deleted
}

// Function to delete a node at a specific position in the list
void deleteAtPosition(struct DoublyLinkedList *list, int position) {
    if (position < 1 || position > size) { // Check if the given position is valid
        printf("Invalid position\n");
        return;
    }

    if (position == 1) {
        deleteAtBeginning(list);
        return;
    } else if (position == size) {
        deleteAtEnd(list);
        return;
    }

    int currentPosition = 1;
    struct Node *temp = list->head;

    while (currentPosition < position) {
        temp = temp->next;
        currentPosition++;
    }

    temp->prev->next = temp->next;
    temp->next->prev = temp->prev;
    free(temp); // Free the memory of the deleted node
    size--; // Decrement size when a node is deleted
}

// Function to search for a node by its value in the list
int searchByValue(struct DoublyLinkedList *list, int value) {
    if (list->head == NULL) {
        return -1; // List is empty
    }

    int position = 1;
    struct Node *temp = list->head;

    while (temp != NULL) {
        if (temp->data == value) {
            return position;
        }
        temp = temp->next;
        position++;
    }

    return -1; // Value not found
}

// Function to search for a node by its position in the list
int searchByPosition(struct DoublyLinkedList *list, int position) {
    if (position < 1 || position > size) { // Check if the given position is valid
        return -1; // Invalid position
    }

    int currentPosition = 1;
    struct Node *temp = list->head;

    while (currentPosition < position) {
        temp = temp->next;
        currentPosition++;
    }

    return temp->data; // Return the data at the specified position
}

// Function to delete the entire doubly linked list
void deleteList(struct DoublyLinkedList *list) {
    struct Node *temp = list->head;
    while (temp != NULL) {
        struct Node *delNode = temp;
        temp = temp->next;
        free(delNode);
    }

    list->head = list->tail = NULL;
    size = 0; // Reset size when deleting the list
    linkListExists = 0; // Reset flag to indicate that the linked list no longer exists
}

// Function to clear input buffer
void clearInputBuffer() {
    int c;
    while ((c = getchar()) != '\n' && c != EOF);
}
