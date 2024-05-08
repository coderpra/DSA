#include <stdio.h>
int findHouse(int r, int unit, int n, int arr[])
{
    if (n == 0)
        return -1;
    int TotalFood = r * unit;
    int foodNow = 0;
    int house;
    for (house = 1; house <= n; house++)
    {
        foodNow += arr[house - 1];
        if (foodNow >= TotalFood)
            break;
    }
    if (foodNow < TotalFood)
        return 0;
    return house;
}
int main()
{
    int r, unit, n;
    printf("r : ");
    scanf("%d", &r);
    printf("unit : ");
    scanf("%d", &unit);
    printf("n : ");
    scanf("%d", &n);
    int arr[n];
    printf("Enter the array : ");
    for (int i = 0; i < n; scanf("%d", &arr[i++]))
        ;
    printf("%d", findHouse(r, unit, n, arr));
    return 0;
}