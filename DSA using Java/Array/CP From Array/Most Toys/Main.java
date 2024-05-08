public class Main {
    static int[] sort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    arr[j]=arr[j]^arr[j+1];
                    arr[j+1]=arr[j]^arr[j+1];
                    arr[j]=arr[j]^arr[j+1];
                }
            }
        }
        return arr;
    }
    static int maxToys(int [] arr, int price){
        arr = sort(arr);
        int num=0;
        int flag=0;
        while(num<arr.length && flag+arr[num]<=price){
            flag+=arr[num];
            num++;
        }
        return num;
    }

    public static void main(String[] args) {
        int[] priceTagOfToys = {1,2,3,4,5,90,23,76,44};
        int priceLimit =40000;
        System.out.println("Number of max toys that can be brought within rupees "+priceLimit+" is "+maxToys(priceTagOfToys, priceLimit));
    }
    
}
