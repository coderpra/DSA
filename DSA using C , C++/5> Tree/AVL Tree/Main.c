#include<stdio.h>
#include<stdlib.h>

typedef struct Node {
    int data;
    struct Node* left;
    struct Node* right;
    int height;
} node;

int getHeight(node* n) {
    if (n == NULL) return 0;
    return n->height;
}

node* createNode(int key) {
    node* n = (node*) malloc(sizeof(node));
    n->left = NULL;
    n->right = NULL;
    n->data = key;
    n->height = 1;

    return n;
}

int getBalanceFactor(node* n) {
    if (n == NULL) return 0;

    return getHeight(n->left) - getHeight(n->right);
}

node* rightRotate(node* y) {
    node* x = y->left;
    node* T2 = x->right;

    // Perform rotation
    x->right = y;
    y->left = T2;

    // Update heights
    y->height = 1 + (getHeight(y->left) > getHeight(y->right) ? getHeight(y->left) : getHeight(y->right));
    x->height = 1 + (getHeight(x->left) > getHeight(x->right) ? getHeight(x->left) : getHeight(x->right));

    // Return new root
    return x;
}

node* leftRotate(node* x) {
    node* y = x->right;
    node* T2 = y->left;

    // Perform rotation
    y->left = x;
    x->right = T2;

    // Update heights
    x->height = 1 + (getHeight(x->left) > getHeight(x->right) ? getHeight(x->left) : getHeight(x->right));
    y->height = 1 + (getHeight(y->left) > getHeight(y->right) ? getHeight(y->left) : getHeight(y->right));

    // Return new root
    return y;
}

node* insert(node* root, int key) {
    if (root == NULL) return createNode(key);

    if (key < root->data) {
        root->left = insert(root->left, key);
    } else if (key > root->data) {
        root->right = insert(root->right, key);
    } else {
        return root; // Duplicate keys are not allowed in BST
    }

    // Update height of this ancestor node
    root->height = 1 + (getHeight(root->left) > getHeight(root->right) ? getHeight(root->left) : getHeight(root->right));

    // Get the balance factor of this ancestor node to check whether this node became unbalanced
    int balance = getBalanceFactor(root);

    // If the node becomes unbalanced, then there are 4 cases

    // Left Left Case
    if (balance > 1 && key < root->left->data)
        return rightRotate(root);

    // Right Right Case
    if (balance < -1 && key > root->right->data)
        return leftRotate(root);

    // Left Right Case
    if (balance > 1 && key > root->left->data) {
        root->left = leftRotate(root->left);
        return rightRotate(root);
    }

    // Right Left Case
    if (balance < -1 && key < root->right->data) {
        root->right = rightRotate(root->right);
        return leftRotate(root);
    }

    // Return the (unchanged) node pointer
    return root;
}

node* convertBSTToAVL(node* bstRoot) {
    if (bstRoot == NULL) return NULL;

    // Create an AVL tree by inserting nodes from the BST
    node* avlRoot = NULL;
    if (bstRoot != NULL) {
        avlRoot = insert(avlRoot, bstRoot->data);
        if (bstRoot->left != NULL)
            avlRoot = insert(avlRoot, bstRoot->left->data);
        if (bstRoot->right != NULL)
            avlRoot = insert(avlRoot, bstRoot->right->data);
    }

    return avlRoot;
}

void preOrder(node* root) {
    if (root != NULL) {
        printf("%d ", root->data);
        preOrder(root->left);
        preOrder(root->right);
    }
}

int main() {
    // Example usage:
    node* bstRoot = createNode(10);
    bstRoot->left = createNode(5);
    bstRoot->right = createNode(20);
    bstRoot->left->left = createNode(3);
    bstRoot->left->right = createNode(7);
    bstRoot->right->left = createNode(15);
    bstRoot->right->right = createNode(25);

    node* avlRoot = convertBSTToAVL(bstRoot);

    printf("Preorder traversal of the AVL tree is:\n");
    preOrder(avlRoot);

    return 0;
}
