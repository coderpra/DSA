import java.util.Scanner;
class Main {
    private static void InsertionSort(int[] arr) {
    int length = arr.length;

    if (length <= 1) {
        return; // Nothing to sort for an empty array or an array with a single element.
    }

    for (int i = 1; i < length; i++) {
        int unsortedValue = arr[i];
        int j = i - 1;

        while (j >= 0 && arr[j] > unsortedValue) {
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = unsortedValue;
    }
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int arr[] = new int[size];

        System.out.print("Enter an array here, leave a blank space between every two elements: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        InsertionSort(arr);

        System.out.print("Sorted array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        sc.close();
    }
    
}
