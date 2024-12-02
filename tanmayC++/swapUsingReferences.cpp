#include <iostream>
using namespace std;
void swap(int& p,int& q){
    int temp = p;
    p = q;
    q = temp;
}
int main(){
    int a,b;
    cout<<"enter a : ";
    cin>>a;
    cout<<"enter b : ";
    cin>>b;
    swap(a,b);
    cout<<a<<endl<<b;

    return 0;
}