#include <iostream>
using namespace std;
void swp(int& a,int& b){
    int temp = a;
    a=b;
    b=temp;
}
void bsort(int* arr,int s){
    bool swpd;
    do{
        swpd=false;
        for(int i=0;i<s-1;i++){
            if(*(arr+i)>*(arr+i+1)){
                swp(*(arr+i),*(arr+i+1));
                swpd=true;
            }
        }

    }while(swpd);
}
int main(){
    int n;
    cout<<"enter size of array : ";
    cin>>n;
    int* arr = new int[n];
    cout<<"enter array elements"<<endl;
    for(int i=0;i<n;i++){
        cout<<i+1<<") -> ";
        cin>>*(arr+i);
    }
    bsort(arr,n);
    cout<<"sorted array..."<<endl;
    for(int i=0;i<n;i++){
        cout<<i+1<<") -> "<<*(arr+i)<<endl;
    }
    delete[] arr;
    return 0;
}