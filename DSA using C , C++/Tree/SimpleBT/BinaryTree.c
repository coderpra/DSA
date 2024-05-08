#include <stdio.h>
#include <stdlib.h>
static int level=-1
;
typedef struct node
{
    int data;
    struct node *left_child;
    struct node *right_child;
} bt; // bt=binary tree

bt *create_node(int d)
{
    bt *current = (bt *)malloc(sizeof(bt));
    current->data = d;
    current->left_child = NULL;
    current->right_child = NULL;
    return current;
}

bt *buildtree(bt *current)
{
    int d;
    printf("which is at level %d of the tree : ", level);
    scanf("%d", &d);
    current = create_node(d);

    if (d == -1)
    {
        return NULL;
    }

    level++;
    printf("Enter data for left child node, ");
    current->left_child = buildtree(current->left_child);

    printf("Enter data for right child node, ");
    current->right_child = buildtree(current->right_child);
    level--;

    return current;
}
int main()
{
    bt *root = NULL;
    printf("Enter data for root node, ");
    level++;
    buildtree(root);

    return 0;
}