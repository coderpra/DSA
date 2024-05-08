import java.util.Scanner;

public class Main {

    // Merge two halves of the array
    private static void conquer(int[] realArr, int[] leftHalf, int[] rightHalf) {
        int leftHalfSize = leftHalf.length;
        int rightHalfSize = rightHalf.length;

        int leftHalfFront = 0;
        int rightHalfFront = 0;
        int realArrFront = 0;

        while (realArrFront < realArr.length) {
            //for lefthalf array is empty but the right half still have elements
            if (leftHalfFront == leftHalfSize && rightHalfFront < rightHalfSize) {
                realArr[realArrFront] = rightHalf[rightHalfFront];
                realArrFront++;
                rightHalfFront++;
            } 
            //for right Half Array is empty but left half still have elements
            else if (rightHalfFront == rightHalfSize && leftHalfFront < leftHalfSize) {
                realArr[realArrFront] = leftHalf[leftHalfFront];
                realArrFront++;
                leftHalfFront++;
            }
            //both right half and left half arrays are not empty 
            else if (leftHalfFront < leftHalfSize && rightHalfFront < rightHalfSize) {
                //when left half front element is smaller than right half front element
                if (leftHalf[leftHalfFront] < rightHalf[rightHalfFront]) {
                    realArr[realArrFront] = leftHalf[leftHalfFront];
                    realArrFront++;
                    leftHalfFront++;
                } 
                //when right half front element is smaller than left half front element
                else if (leftHalf[leftHalfFront] > rightHalf[rightHalfFront]) {
                    realArr[realArrFront] = rightHalf[rightHalfFront];
                    realArrFront++;
                    rightHalfFront++;
                }
            }
        }
    }

    // Divide the array into two halves
    private static void divide(int[] arr) {
        int arrLength = arr.length;
        if (arrLength <= 1) {
            return;
        }

        int midIndex = arrLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[arrLength - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = arr[i];
        }
        for (int i = midIndex; i < arrLength; i++) {
            rightHalf[i - midIndex] = arr[i];
        }

        divide(leftHalf);
        divide(rightHalf);
        conquer(arr, leftHalf, rightHalf);
    }

    // Merge Sort algorithm
    private static void mergeSort(int[] arr) {
        int length = arr.length;
        if (length == 0) {
            System.out.println("Empty Array!!");
            return;
        }
        divide(arr);
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
        mergeSort(arr);

        System.out.print("Sorted array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        sc.close();
    }
}
