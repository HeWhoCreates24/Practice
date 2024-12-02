#include <iostream>
#include <vector>
using namespace std;
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
    while(st<=en){
        int mid=((en-st)/2)+st;
        if(arr[mid]==target){
            cout<<"Target found at index "<<mid+1;
            return 0;
        }
        else if(arr[st]<arr[mid-1]){
            if(arr[st]<=target&&target<=arr[mid-1]){
                en=mid-1;
                continue;
            }
            else{
                st=mid+1;
                continue;
            }
        }
        else{
            if(arr[mid+1]<=target&&target<=arr[en]){
                st=mid+1;
                continue;
            }
            else{
                en=mid-1;
            }
        }
    }
    cout<<"Target not found in array";
    return 0;

}