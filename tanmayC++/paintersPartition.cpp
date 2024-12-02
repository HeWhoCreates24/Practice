#include <iostream>
#include <vector>
using namespace std;
bool isValid(int n,const vector <int> &boards,int m,int maxTime){
    int totalTime=0;
    int painters=1;
    for(int i=0;i<n;i++){
        if(boards[i]>maxTime){
            return false;
        }
        if(totalTime+boards[i]>maxTime){
            painters++;
            totalTime=0;
        }
        totalTime+=boards[i];
    }
    if(painters<=m){
        return true;
    }
    else{
        return false;
    }
}
int paintersPartition(int n,const vector <int> &boards,int m){
    if(m>n){
        return -1;
    }
    
    int sum=0;
    for(int i=0;i<n;i++){
        sum+=boards[i];
    }

    int ans;
    int st=0;
    int en=sum;
    while(st<=en){
        int mid=st+(en-st)/2;
        if(isValid(n,boards,m,mid)){
            ans=mid;
            en=mid-1;
        }
        else{
            st=mid+1;
        }
    }

    return ans;
}
int main(){
    int n = 4;
    vector <int> boards = {40,30,10,20};
    int m = 2;
    cout<<paintersPartition(n,boards,m);
}