/*How can we efficiently sort an array containing only 0s and 1s, placing all the 0s on the left side and all the 1s on the right side of the array, using a C program?*/

#include <stdio.h>

// Function to swap two integers using XOR operator
void swap(int *a, int *b) {
    // Using XOR to swap values without using a temporary variable
    *a = *a ^ *b;
    *b = *a ^ *b;
    *a = *a ^ *b;
}

int main() {
    int n;
    // Input the size of the array
    scanf("%d", &n);
    // Declare an array of size n
    int arr[n];
    // Input the elements of the array
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }
    // Initialize left and right pointers
    int left = 0, right = n - 1;

    // Loop until left pointer is less than right pointer
    while (left < right) {
        // If the element at left pointer is 0, move the left pointer to the right
        if (arr[left] == 0) {
            left++;
        }
        // If the element at right pointer is 1, move the right pointer to the left
        else if (arr[right] == 1) {
            right--;
        }
        // If the element at left pointer is 1 and the element at right pointer is 0,
        // swap the elements and move both pointers
        else {
            swap(&arr[left], &arr[right]);
            left++;
            right--;
        }
    }
    // Output the sorted array
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    return 0;
}

