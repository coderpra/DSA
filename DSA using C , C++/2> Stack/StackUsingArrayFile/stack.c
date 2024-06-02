#include<stdio.h>
#include<stdlib.h>

typedef struct Stack {
    int maxSize;
    int top;
    int bottom;
    int* stack;
} stk;

stk createStack(int size) {
    stk st = { size, -1, -1, NULL };
    st.stack = (int*)malloc(st.maxSize * sizeof(int));
    if (st.stack == NULL) {
        printf("Memory allocation failed\n");
    }
    return st;
}

void resizeStack(stk* st, int size) {
    int* arr = (int*)realloc(st->stack, size * sizeof(int));
    if (arr == NULL) {
        printf("Stack resize failed or out of memory!!\n");
        return;
    }
    st->stack = arr;
    if (size < st->maxSize && st->top >= size) {
        st->top = size - 1;
        st->bottom = (st->top == -1) ? -1 : 0;
    }
    st->maxSize = size;
}

void increaseSize(stk* st, int size) {
    resizeStack(st, st->maxSize + size);
}

void decreaseSize(stk* st, int size) {
    resizeStack(st, st->maxSize - size);
}

void push(stk* st, int data) {
    if (st->top == st->maxSize - 1) {
        printf("Stack Overflow!!\n");
        return;
    }
    if (st->top == -1) st->bottom = 0;
    st->stack[++(st->top)] = data;
}

void pop(stk* st) {
    if (st->top == -1) {
        printf("Stack Underflow!!\n");
        return;
    }
    printf("%d is popped.\n", st->stack[st->top--]);
    if (st->top == -1) {
        st->bottom = -1;
    }
}

int peak(stk* st) {
    return (st->top >= 0) ? st->stack[st->top] : -1;
}

void printStack(stk* st) {
    if (st->top == -1) {
        printf("Stack is empty!!\n");
        return;
    }
    for (int i = st->top; i >= 0; i--) {
        printf("%d\n", st->stack[i]);
    }
}

void freeStack(stk* st){
    free(st->stack);
}
// int main() {
//     stk st = createStack(5);
//     push(&st, 5);
//     push(&st, 10);
//     push(&st, 15);
//     push(&st, 20);
//     push(&st, 25);
//     printStack(&st);
//     increaseSize(&st, 3);
//     push(&st, 30);
//     pop(&st);
//     printStack(&st);
//     free(st.stack);
//     return 0;
// }
