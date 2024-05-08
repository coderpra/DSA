#include <stdio.h>
#include <stdlib.h>
static int level = 0;
typedef struct Node
{
    int data;
    struct Node *left;
    struct Node *right;
} binaryTreeNode;

binaryTreeNode *createNode(int data)
{
    binaryTreeNode *newNode = (binaryTreeNode *)malloc(sizeof(binaryTreeNode));
    if (newNode != NULL)
    {
        newNode->data = data;
        newNode->left = NULL;
        newNode->right = NULL;
    }
    printf("NewNode isn't created using dynamic mamory allocation in heap!!");
    return newNode;
}
binaryTreeNode *createBinaryTree(binaryTreeNode *current, int prevData, int root)
{
    int d;
    (root == 0) ? printf("which is at level %d and child of %d of level %d : ", level, prevData, level - 1) : printf("Which is at level %d : ", level);
    scanf("%d", &d);
    current = createNode(d);
    if (d == -1)
        return NULL;
    printf("Enter the data of left child ");
    current->left = createBinaryTree(current->left, current->data, 0);
    level++;

    printf("Enter the data of right child ");
    current->right = createBinaryTree(current->right, current->data, 0);
    level--;

    return current;
}
int main()
{
    int data;
    printf("Enter data of the root : ");
    scanf("%d", &data);
    binaryTreeNode *root = NULL;
    root = createNode(data);
    if (root == NULL)
        return 0;
    createBinaryTree(root, 0, 1);
    return 0;
}