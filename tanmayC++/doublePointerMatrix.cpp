#include <iostream>
using namespace std;
int main(){
    int r,c;
    cout<<"enter number of rows : ";
    cin>>r;
    cout<<"enter number of columns : ";
    cin>>c;
    int** mtrx = new int*[r];
    for(int i=0;i<r;i++){
        mtrx[i] = new int[c];
    }
    cout<<"enter elements of matrix..."<<endl;
    for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            cout<<"("<<i+1<<","<<j+1<<") -> ";
            cin>>mtrx[i][j];
        }
    }
    cout<<"entered matrix is..."<<endl;
    for(int i=0;i<r;i++){
        cout<<"| ";
        for(int j=0;j<c;j++){
            cout<<mtrx[i][j]<<" ";
        }
        cout<<"|"<<endl;
    }
    for (int i=0;i<r;i++){
        delete[] mtrx[i];
    }
    delete[] mtrx;
    return 0;
}