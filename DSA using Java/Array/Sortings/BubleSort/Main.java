
import java.util.Scanner;

class Sorting{
 private static void ArrayElementSwap(int[] arr, int i, int j) {
    if (i != j) { 
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
}


 public static int[] bubbleSort(int[] arr){
      int length=arr.length;
      if(length==0) {
         System.out.println("No array Is present!!");
         return null;
      }
      if(length==1){
         return arr ;
      }
      int check =1;
      while(check==1){
         for(int i=0;i<length-1;i++){
            if(arr[i]>arr[i+1]){
               ArrayElementSwap(arr, i, i+1);
            }
         }
         check=0;
         for(int i=0;i<length-1;i++){
            if(arr[i]>arr[i+1]){
               check=1;
               break;
            }
         }

      }
      return arr ;
   }


}

public class Main {   
   public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    System.out.print("Enter the size of the array : ");
    int size=sc.nextInt();
    int arr[] = new int[size];

    System.out.print("Enter a array here, leave a blank place between every two element : ");
    for(int i=0;i<size;arr[i++]=sc.nextInt());

    
    arr = Sorting.bubbleSort(arr);

    for (int i = 0; i < size; i++) {
        System.out.print(arr[i] + " ");
    }

    System.out.println();
    sc.close();
   }
}