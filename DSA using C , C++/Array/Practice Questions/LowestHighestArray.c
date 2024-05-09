#include<stdio.h>
#include"/mnt/programming/DSA/DSA using C , C++/Array/Sorting/BubbleSort.c"

void createNewArray(int arr[], int size, int newArr[]) {
    // Sort the original array
    BubbleSortAscending(arr, size);
    
    // Initialize indices for smallest and largest elements
    int left = 0, right = size - 1;
    
    // Fill the new array with elements as described
    for (int i = 0; i < size; i += 2) {
        // Add the smallest element
        newArr[i] = arr[left++];
        
        // Add the largest element
        newArr[i + 1] = arr[right--];
    }
}

int main() {
    int size;
    
    // Input the size of the array
    printf("Enter the size of the array: ");
    scanf("%d", &size);
    
    // Declare arrays for the original and new arrays
    int arr[size]; // Original array
    
    int newArr[size]; // New array
    
    // Input the elements of the array
    printf("Enter %d elements of the array: ", size);
    for (int i = 0; i < size; i++) {
        scanf("%d", &arr[i]);
    }
    
    // Create the new array
    createNewArray(arr, size, newArr);
    
    // Print the new array
    printf("New array with shortest and greatest elements: ");  
    for (int i = 0; i < size; i++) {
        printf("%d ", newArr[i]);
    }
    printf("\n");
    
    return 0;
}