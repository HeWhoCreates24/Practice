#include <iostream>
#include <vector>
using namespace std;
int binS(vector<int> arr,int target,int st,int en){
    if(st<=en){
        int mid=st+(en-st)/2;
        if(arr[mid]==target){
            return mid+1;
        }
        else if(arr[mid]<target){
            return binS(arr,target,mid+1,en);
        }
        else{
            return binS(arr,target,st,mid-1);
        }
    }
    return -1;
}
int main(){
    vector <int> arr;
    int size;
    cout<<"enter size of array : ";
    cin>>size;
    cout<<"enter array...\n";
    for(int i=0;i<size;i++){
        int temp;
        cout<<i+1<<") -> ";
        cin>>temp;
        arr.push_back(temp);
    }
    int target;
    cout<<"enter target value : ";
    cin>>target;
    int st=0;
    int en=size-1;
    cout<<binS(arr,target,st,en);
    return 0;

}