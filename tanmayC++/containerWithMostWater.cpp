#include <iostream>
using namespace std;
int main(){
    int n;
    cout<<"enter number of pillers : ";
    cin>>n;
    int hig[n];
    cout<<"enter the heights of pillers...\n";
    for(int i=0;i<n;i++){
        cout<<i+1<<" -> ";
        cin>>hig[i];
    }
    int maxar=0;
    int curar=0;
    int width;
    int minhig;
    int a,b;
    for(int i=0,j=(n-1);i<j;){
        width=j-i;
        minhig=min(hig[i],hig[j]);
        curar=width*minhig;
        if(curar>maxar){
            a=i;
            b=j;
            maxar=curar;
        }
        hig[i]<hig[j]?i++:j--;
    }
    cout<<"Max water -> "<<maxar<<" square units"<<endl;
    cout<<"between the pillers "<<a+1<<" and "<<b+1;

}