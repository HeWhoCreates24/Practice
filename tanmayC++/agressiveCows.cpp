#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
    //find min index,max index in stalls
    //min ans = 1, max ans = max index - min index;
    //binary search from min ans to max ans
    //make feasibility function, if cows >= c, ans is feasible, find smaller feasible ans
    //if not feasible, try larger ans
    //return least feasible ans
    //edge cases-> n<c,return not enough stalls
    //c==1,return single cow
bool isFeasible(int n,const vector <int> &v,int c,int maxD){
    int cows=1;
    int d=0;
    for(int i=1;i<n;i++){
        if(d+v[i]-v[i-1]<maxD){
            d+=v[i]-v[i-1];
            continue;
        }
        cows++;
        d=0;
    }
    return cows>=c?true:false;
}
int agressiveCows(int n,vector <int> &v,int c){
    if(n<c){
        cout<<"Not enough stalls\n";
        return -1;
    }
    if(c<2){
        cout<<"Insufficient cows\n";
        return -1;
    }

    sort(v.begin(),v.end());

    int minInd=INT_MAX,maxInd=INT_MIN;
    for(int i=0;i<n;i++){
        minInd=min(v[i],minInd);
        maxInd=max(v[i],maxInd);
    }

    int st=0;
    int en=maxInd-minInd;
    int ans=-1;
    while(st<=en){
        int mid=st+(en-st)/2;
        if(isFeasible(n,v,c,mid)){
            ans=mid;
            st=mid+1;
        }
        else{
            en=mid-1;
        }
    }
    
    return ans;
}
int main(){
    vector <int> stalls = {23,-4,-16,4,-22,21};
    int n=stalls.size();
    int c=5;
    cout<<agressiveCows(n,stalls,c);
    return 0;
}