#include <stdlib.h>
long long fib(int n, long long* arr){
    // Base cases
    if (n > -1 && n < 2) {
        return n;
    }
    else {
        // If fib(n) is not already been calculated
        if (arr[n] == 0) {
            arr[n] = fib(n - 2, arr) + fib(n - 1, arr);
        }
        return arr[n];
    }
}

long long fibURec(int n){
    long long *fibArray = (long long*) malloc(sizeof(long long)*(n+1));
    fibArray[1] = 1;
    long long ans = fib(n, fibArray);
    return ans;
}

