#include <iostream>
#include <vector>
using namespace std;
int main(){
    vector <vector <int>> mat={{1,2,3},{4,5,6},{7,8,9}};
    int dSum=0;
    for(int i=0;i<3;i++){
        if(i!=2-i){
            dSum+=mat[i][i]+mat[i][2-i];
        }
        else{
            dSum+=mat[i][i];
        }
    }
    cout<<"Diagonal Sum = "<<dSum;
    return 0;
}