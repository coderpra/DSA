import java.util.Scanner;
public class Main {
    private static void ArrayElementSwap(int[] arr, int i, int j) {
        if (i != j) { 
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }
    private static void SelectionSort(int [] arr){
        int length = arr.length;
        if(length==0) {
         System.out.println("No array Is present!!");
         return ;
      }
      if(length==1){
         return ;
      }
      int check =1;
      int pos=0;
      int min;
      while(check==1){
        min=pos;
        for(int i=pos;i<length;i++){
            if(arr[i]<arr[min]) min=i;
        }
        ArrayElementSwap(arr, min, pos);
        pos++;
        check=0;
         for(int i=0;i<length-1;i++){
            if(arr[i]>arr[i+1]){
               check=1;
               break;
            }
         }
      }
    }
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    System.out.print("Enter the size of the array : ");
    int size=sc.nextInt();
    int arr[] = new int[size];

    System.out.print("Enter a array here, leave a blank place between every two element : ");
    for(int i=0;i<size;arr[i++]=sc.nextInt());
    SelectionSort(arr);

    for (int i = 0; i < size; i++) {
        System.out.print(arr[i] + " ");
    }

    System.out.println();
    sc.close();
    }
    
}
