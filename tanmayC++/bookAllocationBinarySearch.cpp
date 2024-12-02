#include <iostream>
#include <vector>
using namespace std;
bool isValid(int mx,const vector <int> &v,int sts){
    int pgs=0;
    int students=1;
    for(int x: v){
        if(x>mx){
            return false;
        }
        if((pgs+x)>mx){
            students++;
            pgs=0;
        }
        pgs+=x;
    }
    if(students<=sts){
        return true;
    }
    return false;
}
int main(){
    int n;
    cout<<"enter number of books : ";
    cin>>n;
    vector <int> books(n);
    int bksMin=INT_MAX;
    int bksSum=0;
    cout<<"enter number of pages for each book \n";
    for(int i=0;i<n;i++){
        cout<<i+1<<") -> ";
        cin>>books[i];
        bksMin=min(books[i],bksMin);
        bksSum+=books[i];
    }
    int m;
    cout<<"enter number of students : ";
    cin>>m;

    if(m>n){
        cout<<"Not Possible to distribute!";
        return 0;
    }

    int rg=bksSum-bksMin+1;
    vector <int> ans(rg);
    for(int i=0;i<rg;i++){
        ans[i]=bksMin+i;
    }

    int st=0;
    int en=rg-1;
    int answ;
    while(st<=en){
        int mid=st+(en-st)/2;
        if(isValid(mid,books,m)){
            answ=mid;
            en=mid-1;
        }
        else{
            st=mid+1;
        }
    }
    cout<<answ;
    return 0;
}