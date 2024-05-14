#include <iostream>
using namespace std;
int partition(int array[],int low, int high){
  int pivot = array[high];
  int i =low-1;
  for(int j=low;j<high;j++){
    if(array[j]<pivot){
      i++;
      int temp=array[i];
      array[i]=array[j];
      array[j]=array[temp];
    }

  } 
}
void quick_sort(int array[],int low,int high){
  if(low<high){
  int pivotIndex = partition(array,low,high);
  quick_sort(array,low,pivotIndex-1);
  quick_sort(array,pivotIndex+1,high);
  }

}


int main()
{
  int size,i;
    cout << "Enter the size of the array : ";
    cin>>size;
    int inputArray[size];
    for(i=0;i<size;i++){
      cout<<"Enter the element in index "<<i<<" : ";
      cin>>inputArray[i];
    }
    cout<<"Entered Array before sorting is [ ";
    for(i=0;i<size;i++){
      cout<<inputArray[i];
      if(i<size-1)
      cout<<", ";
      }
    cout<<" ]"<<endl;
    quick_sort(inputArray,size);
    cout<<"Entered Array after sorting is [ ";
    for(i=0;i<size;i++){
      cout<<inputArray[i];
      if(i<size-1)
      cout<<", ";
      }
    cout<<" ]"<<endl;
    return 0;
}
