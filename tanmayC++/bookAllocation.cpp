#include <iostream>
#include <vector>
#include <cmath>
using namespace std;
int mod(int a,int b){
    return (int)(sqrt(pow((a-b),2)));
}
int main(){
    vector <int> bks;
    int n;
    cout<<"enter number of books : ";
    cin>>n;
    cout<<"enter number of pages for each book..\n";
    int sum=0;
    for(int i=0;i<n;i++){
        int temp;
        cout<<i+1<<") -> ";
        cin>>temp;
        sum+=temp;
        bks.push_back(temp);
    }
    int m;
    cout<<"enter number of students\n";
    cin>>m;
    if(m>n){
        cout<<"-1";
        return 0;
    }
    vector <int> sts;
    int avg = sum/m;
    int pgs=0;
    for(int i=0;i<n;i++){
        pgs+=bks[i];
        if(i!=n-1&&mod(avg,pgs)<mod(avg,(pgs+bks[i+1]))){
            sts.push_back(pgs);
            pgs=0;
        }
        if(i==n-1){
            sts.push_back(pgs);
        }
    }
    int mx=sts[0];
    for(int i=0;i<m;i++){
        mx=max(sts[i],mx);
    }
    cout<<mx;
    return 0;

}