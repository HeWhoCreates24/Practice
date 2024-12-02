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
int sinEle(const vector <int> &v){
    int size=v.size();
    int st=0;
    int en=size-1;
    while(st<=en){
        int mid=st+(en-st)/2;
        if((mid==0||v[mid]!=v[mid-1])&&(mid==size-1||v[mid]!=v[mid+1])){
            return v[mid];
        }
        else if(v[mid]==v[mid-1]){
            en=mid-2;
        }
        else{
            st=mid+2;
        }
    }
}
int main(){
    vector <int> arr;
    inArr(arr);
    int s;
    if(arr.size()%2==0){
        cout<<"Single Element Not Found!";
        return 0;
    }
    else{
        s=sinEle(arr);
        cout<<"Single Element : "<<s;
        return 0;
    }
}