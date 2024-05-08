#include<stdio.h>
int Binary_Search(int* arr,int data,int leftIndex,int rightIndex){

    int midIndex=(rightIndex+leftIndex)/2;

    int dataIndex = -1; //Index having the data

    //1st base condition (which is data is not present in the array)
    if(leftIndex==rightIndex && arr[midIndex]!=data) return -1;

    //2nd base condition (which is data is in the midIndex of the given range)
    if(arr[midIndex]==data) return midIndex;

    //if data is present either in left portion or in right portion of the array from it's current midIndex
    if(arr[midIndex]!=data){
        if (arr[midIndex]>data)
        {
            dataIndex=Binary_Search(arr,data,leftIndex,midIndex-1);
        }
        else{
            dataIndex=Binary_Search(arr,data,midIndex+1,rightIndex);
        }
    }

    return dataIndex;
}

int main() {
    int sortedArray[] = {1, 2, 3, 4, 5, 7, 8};
    int data = 8;
    printf("element %d is in the index %d.\n", data, Binary_Search(sortedArray, data, 0, (sizeof(sortedArray) / sizeof(sortedArray[0])) - 1));
    return 0;
}