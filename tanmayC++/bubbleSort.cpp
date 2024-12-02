#include <iostream>
using namespace std;
int main(){
    int n;
    cout<<"enter size of array : ";
    cin>>n;

    int a[n];
    cout<<"enter the array...\n";
    for(int i=0;i<n;i++){
        cin>>a[i];
    }
    int m=n;
    bool swapped;
     do{
        swapped=false;
        for(int i=0;i<m-1;i++){
            if(a[i]>a[i+1]){
                int temp=a[i];
                a[i]=a[i+1];
                a[i+1]=temp;
                swapped=true;
            }
        }
        m--;
     }while(swapped);
     cout<<"sorted array is...\n";
     for(int i=0;i<n;i++){
        cout<<a[i]<<endl;
     }
     return 0;
}