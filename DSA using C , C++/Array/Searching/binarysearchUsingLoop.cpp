#include<iostream>
using namespace std;
    int binary_search(int array[],int element,int length){
        int start =0;
        int end = length-1;
        while(start<= end){
            int middle =(start+end)/2;
            if(element == array[middle]){
                return middle;
            }else if(element>array[middle]){
              start= middle+1;
            }else{
                end=middle-1;
            }
        }
        return length;
    }

    int main() {
        int first,last,check,size;
        cout<<"Enter the first element of the array : ";
        cin>>first;
        cout<<"Enter the last element of the array which is must be greater than the first element : ";
        cin>>last;
        size=last-first+1;
        int input_array[size];
        for(int i=0;i<size;i++){
            input_array[i]=first+i;
        }
        cout<<"Enter the number to be searched : ";
        cin>>check;
        int index=binary_search(input_array,check,size);
        if (index==size){
            cout<<"The number isn't present ."<<endl;
        }
        else{
            cout<<"The number is present in the position "<<index<<endl;
        }
        return 0;
    }
