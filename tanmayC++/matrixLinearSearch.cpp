#include <iostream>
using namespace std;
int main(){
    pair <int,int> d;
    cout<<"enter dimensions of matrix : ";
    cin>>d.first>>d.second;
    int mat[d.first][d.second];
    cout<<"enter matrix"<<endl;
    for(int i=0;i<d.first;i++){
        for(int j=0;j<d.second;j++){
            int temp;
            cin>>temp;
            mat[i][j]=temp;
        }
    }
    int target;
    cout<<"enter target"<<endl;
    cin>>target;
    pair <int,int> index = {-1,-1};
    for(int i=0;i<d.first;i++){
        for(int j=0;j<d.second;j++){
            if(mat[i][j]==target){
                index={i,j};
                break;
            }
        }
    }
    cout<<index.first<<","<<index.second;
    return 0;
}