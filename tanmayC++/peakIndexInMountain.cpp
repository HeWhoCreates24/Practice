#include <iostream>
#include <vector>
using namespace std;
void inArr(vector <int> &v){
    int size;
    cout<<"enter size of array : ";
    cin>>size;
    cout<<"enter array elements...\n";
    for(int i=0;i<size;i++){
        int temp;
        cout<<i<<") -> ";
        cin>>temp;
        v.push_back(temp);
    }
}
void outArr(const vector <int> &v){
    int i=0;
    for(int x: v){
        cout<<i++<<") -> "<<x<<endl;
    }
}
int peakOf(const vector <int> &v){
    int size=v.size();
    int st=1;
    int en=size-2;
    while(st<=en){
        int mid=st+(en-st)/2;
        if((v[mid-1]<v[mid]&&v[mid]>v[mid+1])){
            return mid;
        }
        else if((v[mid-1]<v[mid])){
            st=mid+1;
            continue;
        }
        else{
            en=mid-1;
            continue;
        }
    }
    return -1;
}
int main(){
    vector <int> arr;
    inArr(arr);
    int p;
    if(arr.size()>2){
    p=peakOf(arr);
    }
    else if(arr.size()==1){
        p=0;
    }
    else{
        p=-1;
    }
    if(p!=-1){
        cout<<"Peak value at index "<<p;
    }
    else{
        cout<<"No peak value found!";
    }
    return 0;
}