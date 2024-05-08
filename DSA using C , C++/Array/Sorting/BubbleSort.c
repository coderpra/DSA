#include <stdio.h>
#include <stdlib.h>
void BubbleSortAscending(int *arr, int size)
{
    for (int i = 0; i < size - 1; i++)
    {
        for (int j = 0; j < size - 1 - i; j++)
        {
            if (arr[j] > arr[j + 1])
            {
                arr[j] = arr[j + 1] ^ arr[j];
                arr[j + 1] = arr[j + 1] ^ arr[j];
                arr[j] = arr[j + 1] ^ arr[j];
            }
        }
    }
}

void BubbleSortDescending(int *arr, int size)
{
    for (int i = 0; i < size - 1; i++)
    {
        for (int j = 0; j < size - 1 - i; j++)
        {
            if (arr[j] < arr[j + 1])
            {
                arr[j] = arr[j + 1] ^ arr[j];
                arr[j + 1] = arr[j + 1] ^ arr[j];
                arr[j] = arr[j + 1] ^ arr[j];
            }
        }
    }
}

int main()
{
    int n, k;
    printf("Enter the size : ");
    scanf("%d", &n);
    int *arr = (int *)malloc(n * sizeof(int));
    printf("Enter the Whole Array in same line and the elements separated by space.\n");
    for (int i = 0; i < n; scanf("%d", &arr[i++]))
        ;
    printf("[ ");
    for (int i = 0; i < n - 1; printf("%d, ", arr[i++]))
        ;
    printf("%d ]\n", arr[n - 1]);
    printf("Enter position that must be lesser than n : ");
    scanf("%d", &k);
    if (k > n)
        return (printf("Wrong input!!") * 0);
    BubbleSortAscending(arr, k);
    BubbleSortDescending(&arr[k], n - k);
    printf("[ ");
    for (int i = 0; i < n - 1; printf("%d, ", arr[i++]))
        ;
    printf("%d ]\n", arr[n - 1]);
}