import java.util.Scanner;

class Main {
    static int LinearSearch(int[] arr, int data) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of the array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        System.out.print("Enter an array here, every element must be separated by one blank space: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the data to be searched: ");
        int data = sc.nextInt();

        System.out.print("Array: ");
        for (int i = 0; i < size; System.out.print(arr[i++] + " "));
        System.out.println();

        int pos = LinearSearch(arr, data);

        System.out.println("The data is " + ((pos > -1) ? ("present in the position " + pos + " of") : "not present in") + " the array.");

        sc.close();
    }
}

