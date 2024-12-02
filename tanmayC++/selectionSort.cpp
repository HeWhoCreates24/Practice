#include <iostream>
#include <vector>
using namespace std;
void selSort(vector <int> &v){
    int n=v.size();
    for(int i=0;i<n;i++){
        int in;
        for(int j=i;j<n;j++){
            if(j==i){
                in=j;
            }
            if(v[in]>v[j]){
                in=j;
            }
            
        }
        int temp=v[i];
        v[i]=v[in];
        v[in]=temp;
    }
}
int main(){
    vector <int> arr = {5,4,6,2,3,1};
    selSort(arr);
    for(int x: arr){
        cout<<x<<endl;
    }
    return 0;
}