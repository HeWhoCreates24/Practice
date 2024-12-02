#include <iostream>
using namespace std;
int main(){
    int x,y,z;
    cout<<"enter dimentions of 2D array...\n";
    cout<<"number of rows -> ";cin>>x;
    cout<<"number of columns -> ";cin>>y;
    z=x*y;
    int a[x][y],b[z];
    cout<<"enter the elements of the 2D array...\n";
    for(int i=0;i<x;i++){
        for(int j=0;j<y;j++){
            cout<<"( "<<i<<", "<<j<<") -> ";
            cin>>a[i][j];
            b[(x*i)+j]=a[i][j];
        }
    }
    cout<<"converetred 1D array...\n";
    for(int i=0;i<z;i++){
        cout<<"( "<<i<<") -> "<<b[i]<<endl;
    }
    return 0;
}