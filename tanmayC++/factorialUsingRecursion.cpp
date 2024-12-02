#include <iostream>
using namespace std;
int fact(int n){
    if(n==0||n==1) return 1;
    else return (n*fact(n-1));
}
int main(){
    int n;
    cout<<"enter a nummber : ";
    cin>>n;
    int f=fact(n);
    cout<<"factorial of "<<n<<" is "<<f;
    return 0;
}