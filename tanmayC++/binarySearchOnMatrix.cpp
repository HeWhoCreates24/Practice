#include <iostream>
#include <vector>
using namespace std;
int main(){
    vector <vector <int>> mat={{1,2,3},{4,5,6},{7,8,9}};
    int m=mat.size(),n=mat[0].size();
    int tg=7;
    int str=0,enr=m-1;
    int row=-1;
    while(str<=enr){
        int midr=str+(enr-str)/2;
        if(tg>=mat[midr][0]&&tg<=mat[midr][n-1]){
            row=midr;
            break;
        }
        else if(tg<mat[midr][0]){
            enr=midr-1;
        }
        else{
            str=midr+1;
        }
    }
    if(row==-1){
        cout<<"Target not found";
    }
    else{
        int col=-1;
        int st=0,en=n-1;
        while(st<=en){
            int mid=st+(en-st)/2;
            if(mat[row][mid]==tg){
                col=mid;
                break;
            }
            else if(mat[row][mid]<tg){
                st=mid+1;
            }
            else{
                en=mid-1;
            }
        }
        if(col==-1){
            cout<<"Target not found";
        }
        else{
            cout<<"Target found at cell "<<row<<", "<<col;
        }
    }
    return 0;
}