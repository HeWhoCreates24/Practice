#include <iostream>
#include <vector>
using namespace std;
int main(){
    vector <vector <int>> mat = {{1,2,3},{4,5,6},{7,8,9}};
    int maxr=0,maxc=0;
    for(int i=0;i<3;i++){
        int rsum=0,csum=0;
        for(int j=0;j<3;j++){
            rsum+=mat[i][j];
            csum+=mat[j][i];
        }
        maxr=max(maxr,rsum);
        maxc=max(maxc,csum);
    }
    cout<<"max row sum = "<<maxr<<" ; max column sum = "<<maxc;
}