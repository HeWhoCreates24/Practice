#include <iostream>
#include <vector>
using namespace std;
pair <int ,int > binS(const vector <vector <int>> &mat,const int &tg){
    int m=mat.size(),n=mat[0].size();
    pair <int,int> st={0,0},en={m-1,n-1},mid;
    while(st.first<=en.first&&st.second<=en.second){
        mid={st.first,en.second};
        if(mat[(mid.first)][(mid.second)] == tg){
            return mid;
        }
        else if(mat[(mid.first)][(mid.second)] < tg){
            st.first++;
        }
        else{
            en.second--;
        }
    }
    return {-1,-1};
}
int main(){
    vector <vector <int>> mat={{1,4,7},{3,5,8},{6,8,9}};
    int tg=9;
    pair <int ,int > ans = binS(mat,tg);
    cout<<ans.first<<","<<ans.second;
    return 0;
}