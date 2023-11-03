import java.util.Scanner;

class Main {

    static int BinarySearch(int[] arr, int firstPos, int lastPos, int data) {
        if (firstPos == lastPos && arr[firstPos] != data) {
            return -1;
        }
        int mid = firstPos + (lastPos - firstPos) / 2;
        if (arr[mid] == data) {
            return mid;
        } else if (arr[mid] > data) {
            return BinarySearch(arr, firstPos, mid - 1, data);
        } else if (arr[mid] < data) {
            return BinarySearch(arr, mid + 1, lastPos, data);
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of the array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        System.out.print("Enter a sorted array here, every element must be separated by one blank space: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter which data to be searched: ");
        int data = sc.nextInt();

        
        System.out.print("Array: ");
        for (int i = 0; i < size; System.out.print(arr[i++] + " "));
        System.out.println();

        int pos = BinarySearch(arr, 0, size - 1, data);
        
        System.out.println("The Data is " + ((pos > -1) ? ("present in the position " + pos+" of") : "not present in")+" the array.");

        sc.close();

    }
    
}
