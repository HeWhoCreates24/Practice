#include <iostream>
#include <vector>
using namespace std;
void permute(vector <int> &v){
    int n=v.size();
    int pivot=-1;
    for(int i=n-2;i>=0;i--){
        if(v[i]<v[i+1]){
            pivot=i;
            break;
        }
    }
    if(pivot==-1){
        for(int i=0,j=n-1;i<j;){
        swap(v[i],v[j]);
        i++;
        j--;
        }
        return;
    }
    int gtp;
    for(int i=n-1;i>pivot;i--){
        if(v[i]>v[pivot]){
            gtp=i;
            break;
        }
    }
    swap(v[pivot],v[gtp]);
    for(int i=pivot+1,j=n-1;i<j;){
        swap(v[i],v[j]);
        i++;
        j--;
    }

}
int main(){
    vector <int> arr = {1,2,5,4,3};
    permute(arr);
    for(int x: arr){
        cout<<x;
    }
    return 0;
}