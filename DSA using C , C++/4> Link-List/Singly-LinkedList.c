#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node* next;
} node;

typedef struct LinkedList {
    node* head;
    node* flagptr;
    int flag;
    int noNode;
} ll;

ll* createLinkedList() {
    ll* linkedlist = (ll*) malloc(sizeof(ll));  // Create a new linked list instance
    if (linkedlist == NULL) {
        printf("Memory allocation failed\n");
        return NULL;
    }

    linkedlist->head = (node*) malloc(sizeof(node));  // Allocate memory for the head node
    if (linkedlist->head == NULL) {
        printf("Memory allocation failed\n");
        free(linkedlist);
        return NULL;
    }
    linkedlist->head->next = NULL;  // Initialize head's next to NULL
    linkedlist->noNode = 0;
    linkedlist->flagptr = linkedlist->head;  // Set flagptr to head
    linkedlist->flag = 0;
    
    return linkedlist;
}

int LinkedListSize(ll* linkedlist) {
    return linkedlist->noNode;
}

void addAtIndex(ll* list, int data, int index) {
    if (index > list->noNode + 1) {
        printf("Index %d is out of bounds!!\nData will be added at the end.\n", index);
        index = list->noNode + 1;
    }
    if (list->flag > index) {
        list->flag = 0;
        list->flagptr = list->head;
    }
    node* current = (node*) malloc(sizeof(node));
    if (current == NULL) {
        printf("Memory allocation failed\n");
        return;
    }
    current->data = data;
    while (list->flag < index - 1) {
        list->flagptr = list->flagptr->next;
        list->flag++;
    }
    current->next = list->flagptr->next;
    list->flagptr->next = current;
    list->noNode++;
}

void addAtEnd(ll* list, int data) {
    addAtIndex(list, data, list->noNode + 1);
}

void removeFromIndex(ll* list, int index) {
    if (index > list->noNode || index < 1) {
        printf("Index %d is out of bounds!!\nSo index cannot be deleted!!\n", index);
        return;
    }
    if (list->flag > index) {
        list->flag = 0;
        list->flagptr = list->head;
    }
    while (list->flag < index - 1) {
        list->flagptr = list->flagptr->next;
        list->flag++;
    }
    node* toRemove = list->flagptr->next;
    list->flagptr->next = toRemove->next;
    free(toRemove);
    list->noNode--;
}

void removeFromEnd(ll* list) {
    removeFromIndex(list, list->noNode);
}

void printLinkedList(ll* list) {
    if (list->noNode == 0){
        printf("LinkedList is Empty!!\n");
        return;
    }
    node* current = list->head->next;
    while (current) {
        printf("%d ", current->data);
        current = current->next;
    }
    printf("\n");
}

void freeLinkedList(ll* linkedlist) {
    node* current = linkedlist->head;
    while (current) {
        node* temp = current;
        current = current->next;
        free(temp);
    }
    free(linkedlist);
}

void operationsOverLinkedList(ll* linkedlist) {
    int check = 1;
    int option = 0;
    int place = 0;
    int data = 0;
    int index = 0;
    while (check) {
        printf("\t\t\tDo you want to do an operation or stop the program?\n\t\t\tEnter 0 to End or 1 to continue accordingly: ");
        scanf("%d", &check);
        if (!check) {
            printf("STOPPED !!\n");
            continue;
        }

        printf("\t\t\t\t\t\t\t\t\tTo add node Enter 1\n\t\t\t\t\t\t\t\t\tTo remove node Enter 2\n\t\t\t\t\t\t\t\t\tTo print LinkedList Enter 3\n\t\t\t\t\t\t\t\t\tEnter: ");
        scanf("%d", &option);

        switch (option) {
            case 1:
                printf("Enter the data you want to store: ");
                scanf("%d", &data);
                printf("To enter at end enter 1\nTo enter at any index enter 2\nEnter: ");
                scanf("%d", &place);
                switch (place) {
                    case 1:
                        addAtEnd(linkedlist, data);
                        break;
                    case 2:
                        printf("Enter the index where you want to store: ");
                        scanf("%d", &index);
                        addAtIndex(linkedlist, data, index);
                        break;
                    default:
                        printf("Wrong Input!!\n");
                }
                break;
            case 2:
                printf("To remove from the end enter 1\nTo remove from any specific index enter 2\nEnter: ");
                scanf("%d", &place);
                switch (place) {
                    case 1:
                        removeFromEnd(linkedlist);
                        break;
                    case 2:
                        printf("Enter the index that you want to delete: ");
                        scanf("%d", &index);
                        removeFromIndex(linkedlist, index);
                        break;
                    default:
                        printf("Wrong Input!!\n");
                }
                break;
            case 3:
                printLinkedList(linkedlist);
                break;
            default:
                printf("Wrong Input!!\n");
        }
    }
}

int main() {
    ll* ll1 = createLinkedList();
    if (ll1 == NULL) {
        return 1;
    }
    operationsOverLinkedList(ll1);
    freeLinkedList(ll1);
    return 0;
}
