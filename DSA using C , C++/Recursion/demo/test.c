#include<stdio.h>
#include"FibULoop.c"
#include"fibURec.c"


int main(){
    int n;
    printf("Enter the value for n : ");
    scanf("%d",&n);

    printf("fib of first %d element is %lld\n",n,fibULoop(n)); //using loop
    printf("fib of first %d element is %lld\n",n,fibURec(n)); //using rec
    return 0;
}
