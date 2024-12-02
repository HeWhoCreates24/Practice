#include <iostream>
using namespace std;
int main(){
    int a,b;
    cout<<"enter two numbers\n";
    cout<<"a -> ";cin>>a;
    cout<<"b -> ";cin>>b;
    a=a+b;
    b=a-b;
    a=a-b;
    cout<<"swaped numbers are...\n";
    cout<<"a -> "<<a<<endl;
    cout<<"b -> "<<b;
    return 0;
}