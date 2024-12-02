#include <iostream>
using namespace std;
int euAlgo(int a,int b){
    while(a!=0&&b!=0){
        if(a>b){
            a=a%b;
        }
        else{
            b=b%a;
        }
    }
    return a==0?b:a;
}
int main(){
    int a,b;
    cin>>a>>b;
    int hcf=euAlgo(a,b);
    cout<<hcf;
    return 0;
}