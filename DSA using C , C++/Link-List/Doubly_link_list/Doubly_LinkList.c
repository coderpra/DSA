#include <stdio.h>
#include <stdlib.h>
typedef struct Node
{
    struct Node *prev;
    int data;
    struct Node *next;
} node;
void createNode(node *head, int data, int givenPos)
{
    node *new = (node *)malloc(sizeof(node));
    new->data = data;
    new->next = NULL;
    // Insertion At beginning or any type of insertion when linklist is empty
    if (givenPos == 1 || head->next == NULL)
    {
        if (givenPos > 1)
        {
            printf("The LinkList is empty!!\nSo it don't have the given position %d, so the new node is adding at the end.\n", givenPos);
        }
        new->prev = head;
        if (head->next != NULL)
        {
            new->next = head->next;
            head->next->prev = new;
        }
        head->next = new;
        return;
    }
    node *current = head;
    int currentPos = 0;
    // insertion at end
    if (givenPos == 0)
    {
        while (current->next != NULL)
        {
            current = current->next;
        }
        new->prev = current;
        current->next = new;
        return;
    }

    // insertion at anyposition
    while (current->next != NULL && currentPos < givenPos)
    {
        current = current->next;
        currentPos++;
    }
    if (currentPos < givenPos && current->next == NULL)
    {
        if (currentPos < givenPos - 1 && current->next == NULL)
        {
            printf("The LinkList is shorter to have the given position %d, so the new node is adding at the end.\n", givenPos);
        }
        new->prev = current;
        current->next = NULL;
        return;
    }
    else if (currentPos == givenPos)
    {
        new->prev = current->prev;
        new->next = current;
        current->prev->next = new;
        current->prev = new;
    }
}
void deleteNode(node *head, int givenPos)
{
    if (head->next == NULL)
    {
        printf("The link-list is empty!!\n");
        return;
    }
    node *delete = head->next;
    int currentPos = 1;
    if (givenPos == 1 || (givenPos == 0 && head->next->next == NULL))
    {
        if (delete->next == NULL)
        {
            head->next = NULL;
            free(delete);
            return;
        }
        head->next = delete->next;
        delete->next->prev = head;
        free(delete);
        return;
    }
    else if (givenPos == 0)
    {
        while (delete->next != NULL)
            delete = delete->next;
        delete->prev->next = NULL;
        free(delete);
        return;
    }
    else if (givenPos > 1)
    {
        while (delete->next != NULL && currentPos < givenPos)
        {
            delete = delete->next;
            currentPos++;
        }
        if (delete->next == NULL && currentPos < givenPos)
        {
            printf("The given position doesn't exist in the linklist so it cann't be deleted.\n");
            return;
        }
        if (currentPos == givenPos)
        {
            delete->next->prev = delete->prev;
            delete->prev->next = delete->next;
            free(delete);
        }
    }
}
void printLinkList(node *head)
{
    if (head->next == NULL)
    {
        printf("The link-list is empty!!\n");
        return;
    }
    node *flag = head;
    while (flag->next != NULL)
    {
        flag = flag->next;
        printf("%d", flag->data);
        if (flag->next != NULL)
            printf("<==>");
    }
    printf("\n");
}
int main()
{
    node *head = (node *)malloc(sizeof(node));
    head->prev = NULL;
    head->next = NULL;
    int choice = 0, position = 0, data = 0;
    while (1)
    {
        printf("Enter 1 to create a node.\nEnter 2 to delete a node.\nEnter 3 to print the linklist.\nEnter 4 to stop.\nEnter : ");
        scanf("%d", &choice);
        switch (choice)
        {
        case 1:
            printf("Enter the position where you wanna insert the data (1 for insert at beggining, 0 for at end and any integer number for random position)\nEnter : ");
            scanf("%d", &position);
            printf("Enter a integer data : ");
            scanf("%d", &data);
            createNode(head, data, position);
            break;
        case 2:
            printf("Enter the position that you wanna delete a data (1 for insert at beggining, 0 for at end and any integer number for random position)\nEnter : ");
            scanf("%d", &position);
            deleteNode(head, position);
            break;
        case 3:
            printLinkList(head);
            break;
        case 4:
            printf("Bye Bye!!\n");
            return 0;
        default:
            printf("Insert Correctly from 1 to 4!!\n");
        }
    }
    return 0;
}