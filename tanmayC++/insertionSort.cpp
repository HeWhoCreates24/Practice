#include <iostream>
#include <vector>
using namespace std;
void inSort(vector <int> &v){
    int n=v.size();
    for(int i=1;i<n;i++){
        int curr=v[i];
        int j=i-1;
        for(;j>=0;j--){
            if(v[j]<=curr){
                break;
            }
            else{
                v[j+1]=v[j];
            }
        }
        v[j+1]=curr;
    }
}
int main(){
    vector <int> arr = {5,6,3,2,1,4,7,9,8};
    inSort(arr);
    for(int x: arr){
        cout<<x<<endl;
    }
    return 0;
}