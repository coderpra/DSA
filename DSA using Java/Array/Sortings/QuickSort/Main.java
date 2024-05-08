public class Main {

    static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j] ;
        arr[j] = arr[i] ^ arr[j] ;
        arr[i] = arr[i] ^ arr[j] ;
    }

    static void quickSort(int[] arr, int low, int high){
        if (low < high) {
            int pivot = arr[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (arr[j] < pivot) {
                    i++;
                    swap(arr, i, j);
                }
            }
            int pivotPosition = i+1;
            quickSort(arr, low, pivotPosition - 1);
            quickSort(arr, pivotPosition + 1, high);
        }
    }

    public static void main(String[] args){
        int[] arr = {2, 0, 4, 8, 7, 1, 21};
        
        System.out.print("Array before sorting: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
        quickSort(arr, 0, arr.length - 1);
        
        System.out.println("\nArray after sorting: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
