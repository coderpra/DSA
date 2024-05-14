#include <stdio.h>
#include <stdlib.h> 

void swap(int *xp, int *yp)
{
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}

void SelectionSort(int* arr, int size){
    int minIndex;
    for(int i=0;i<size;i++){
        minIndex = i;
        for (int j=i+1; j < size; j++)
        {
            if(arr[minIndex]>arr[j]){
                minIndex = j;
            }
        }
        if(minIndex!=i){
            swap(&arr[minIndex], &arr[i]);
        }
    }
}

int main() {
    int* arr;
    int size;

    // Input size of the array
    printf("Enter size of the array: ");
    scanf("%d", &size);

    // Allocate memory for the array
    arr = (int*)malloc(size * sizeof(int));

    // Input elements of the array
    printf("Enter the array elements separated by space: ");
    for (int i = 0; i < size; i++) {
        scanf("%d", &arr[i]);
    }

    // Perform merge sort
    SelectionSort(arr, size);

    // Output sorted array
    printf("Sorted array: ");
    for (int i = 0; i < size; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    // Free dynamically allocated memory
    free(arr);

    return 0;
}
