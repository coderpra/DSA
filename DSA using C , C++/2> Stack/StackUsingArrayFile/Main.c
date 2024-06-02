#include <stdio.h>
#include "/mnt/programming/DSA/DSA using C , C++/2> Stack/StackUsingArrayFile/stack.c"


int main() {
    stk st = createStack(5);
    push(&st, 5);
    push(&st, 10);
    push(&st, 15);
    push(&st, 20);
    push(&st, 25);
    printStack(&st);
    increaseSize(&st, 3);
    push(&st, 30);
    pop(&st);
    printStack(&st);
    freeStack(&st);
    return 0;
}