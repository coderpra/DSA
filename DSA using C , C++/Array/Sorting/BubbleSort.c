#include <stdio.h>
#include <stdlib.h>
void BubbleSortAscending(int *arr, int size)
{
    for (int i = 0; i < size - 1; i++)
    {
        for (int left = 0; left < size - 1 - i; left++)
        {
            int right =left+1;
            if (arr[left] > arr[right])
            {
                arr[left] = arr[right] ^ arr[left];
                arr[right] = arr[right] ^ arr[left];
                arr[left] = arr[right] ^ arr[left];
            }
        }
    }
}


int main()
{
    int n;
    printf("Enter the size : ");
    scanf("%d", &n);
    int *arr = (int *)malloc(n * sizeof(int));

    printf("Enter the Whole Array in same line and the elements separated by space.\n");
    for (int i = 0; i < n; scanf("%d", &arr[i++]));

    BubbleSortAscending(arr,n);

    for(int i = 0;i<n;printf("%d ",arr[i++]));
    printf("\n");
    free(arr);
 return 0;       
}