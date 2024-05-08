#include <stdio.h>
void findpairs(int arr[], int length)
{
    int print = 0;

    for (int i = 0; i < length; i++)
    {
        for (int j = i; j < length; j++)
        {
            for (int position = 0; position < length; position++)
            {
                if (arr[position] == arr[i] + arr[j])
                {
                    print++;
                    printf("arr[%d]+arr[%d]=array[%d]\n", i, j, position);
                }
            }
        }
    }
    if (print == 0)
    {
        printf("0\n");
    }
}
int main()
{
    int n, arr[100];
    printf("Enter length of the array: ");
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
    {
        printf("arr[%d] = ", i);
        scanf("%d", &arr[i]);
    }
    findpairs(arr, n);
    return 0;
}