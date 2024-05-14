#include <stdio.h>
#include <stdlib.h> 

// Function to merge two sorted subarrays
void conquer(int* arr, int start, int middle, int end) {
    int leftSize = middle - start + 1;
    int rightSize = end - middle;

    // Create temporary arrays
    int left[leftSize];
    int right[rightSize];

    // Copy data to temporary arrays left[] and right[]
    for (int i = 0; i < leftSize; i++)
        left[i] = arr[start + i];
    for (int j = 0; j < rightSize; j++)
        right[j] = arr[middle + 1 + j];

    // Merge the temporary arrays back into arr[start..end]
    int i = 0; // Initial index of left subarray
    int j = 0; // Initial index of right subarray
    int k = start; // Initial index of merged subarray

    while (i < leftSize && j < rightSize) {
        if (left[i] <= right[j]) {
            arr[k] = left[i];
            i++;
        }
        else {
            arr[k] = right[j];
            j++;
        }
        k++;
    }

    // Copy the remaining elements of left[], if any
    while (i < leftSize) {
        arr[k] = left[i];
        i++;
        k++;
    }

    // Copy the remaining elements of right[], if any
    while (j < rightSize) {
        arr[k] = right[j];
        j++;
        k++;
    }
}

// Function to divide the array into two halves recursively
void divide(int* arr, int start, int end) {
    if (start < end) {
        int middle = start + (end - start) / 2; // Find the middle point

        // Recursively divide the left and right halves
        divide(arr, start, middle);
        divide(arr, middle + 1, end);

        // Merge the divided halves
        conquer(arr, start, middle, end);
    }
}

// Function to perform merge sort
void mergeSort(int* arr, int size) {
    divide(arr, 0, size - 1);
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
    mergeSort(arr, size);

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
