long long fibULoop(int n){
    if(n>-1 && n<2) return n;
    long long firstElement=0;
    long long secoundElement = 1;
    long long next;
    for(int i=2;i<=n;i++){
        next = firstElement+secoundElement;
        firstElement = secoundElement;
        secoundElement = next;
    }

    return next;
}