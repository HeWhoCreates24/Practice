#include <iostream>
using namespace std;
void swap(int* a,int* b){
    int temp = *a;
    *a = *b;
    *b = temp;
}
int main(){
    int a,b;
    cout<<"enter a : ";
    cin>>a;
    cout<<"enter b : ";
    cin>>b;
    swap(&a,&b);
    cout<<a<<endl<<b;
    return 0;
}