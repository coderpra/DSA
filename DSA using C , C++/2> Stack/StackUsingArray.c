#include<stdio.h>
#include<stdlib.h>

static int maxSize=0;
static int top=-1;
static int bottom=-1;

int* stack=NULL;

int* createStack(int size){
    maxSize=size;
    int* arr= (int*)malloc(maxSize*sizeof(int));
    if(arr==NULL){
        printf("stack creation failed!!\n");
        return NULL;
    }
    return arr;
}

void resizeStack(int size) {
    int* arr = (int*)realloc(stack, size * sizeof(int));
    if (arr == NULL) {
        printf("Stack resize failed or out of memory!!\n");
        return;
    }
    maxSize = size;
    stack = arr;
    if (size < maxSize) {
        top = size - 1;
    }
}


void increaseSize(int size){
    resizeStack(maxSize+size);
}

void decreaseSize(int size){
    resizeStack(maxSize-size);
}
void push(int data){
    if(top==maxSize-1){
        printf("Stack Overflow!!\n");
        return;
    }
    if(top==-1) bottom++;
    top++;
    stack[top]=data;
}

void pop(){
    if(top==-1){
        printf("Stack Underflow!!\n");
        return;
    }
    if(top==0) bottom--;
    top--;
    printf("%d is popped.\n",stack[top+1]);
}
int peak(){
    return (top>=0)?stack[top]:-1;
}

void printStack(){
    if(top==-1){
        printf("Stack is empty!!\n");
        return;
    }
    for(int i=top;i>=0;i--){
        printf("%d\n",stack[i]);
    }
}


int main(){
    stack=createStack(5);
    push(5);
    push(10);
    push(15);
    push(20);
    push(25);
    printStack();
    increaseSize(3);
    push(30);
    pop();
    printStack();
    free(stack);
}