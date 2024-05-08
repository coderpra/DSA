#include<stdio.h>
int GoodArraySum(int arr[],int start, int stop){
    int sum=0;
    for(int i=start;i<=stop;i++){
        sum+=arr[i];
    }
    return sum;
}
int LinearSearch(int arr[],int start,int size,int data){
    for(int i=start;i<size;i++){
        if(arr[i]==data) return i;
    }
    return -1;
}

int test(int arr[],int size, int good){
    int data=0,pos=0;
    for(int i =0;i<size;i++){
        data=good-arr[i];
        if(data<0) data*=-1;
        pos=LinearSearch(arr,i+1,size-1,data);
        if(pos !=-1){
            printf("The good array sum between %d at index %d and %d at index %d is %d.\n",arr[i],i,arr[pos],pos,GoodArraySum(arr,i,pos));
            return 0;
        }
    }
    return -1;
}
int main(){
    int size=0,good=0;
    printf("Enter the size of the array : ");
    scanf("%d",&size);
    int arr[size];
    for(int i=0;i<size;i++){
        printf("Enter the element at position %d : ",i);
        scanf("%d",&arr[i]);
    }
    printf("Enter the good number : ");
    scanf("%d",&good);
    int check=test(arr,size,good);
    (check==-1)?printf("No good array present in the array!!\n"):0;
    return 0;
}