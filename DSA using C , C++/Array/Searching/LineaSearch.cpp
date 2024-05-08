#include<iostream>
using namespace std;
    int find(int list[],int n){
        int i,length=sizeof(list)/sizeof(list[0]);
        for(i=0;i<length;i++){
            if (list[i]==n){
            return i;}
        }
        return length;
    }
    int main() {
        int size,flag,check;
        cout<<"Enter size of the array : ";
        cin>>size;
        int array[size];
        for(flag=0;flag<size;flag++){
            cout<<"Enter a element : ";
            cin>>array[flag];
        }
        cout<<"Enter a number to be checked wether it is present in the array or not : ";
        cin>>check;
        flag = find(array,check);
        if(flag==size){
         cout<<"The number is not present in the array."<<endl;
         return 0 ;   
        }
        cout<<"The number is present at index "<<flag<<endl;
        return 0;
    }
