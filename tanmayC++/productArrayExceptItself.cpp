#include <iostream>
#include <vector>
using namespace std;
int main(){
    vector <int> v,ans;
    cout<<"Enter elements of vector (type any non-integer to stop)\n";
    int input;
    int size=0;
    while(cin>>input){
        size++;
        v.push_back(input);
        ans.push_back(1);
    }
    cin.clear();
    int pref=1;
    int suff=1;
    for(int i=0,j=size-1;j>0;i++,j--){
        pref*=v[i];
        suff*=v[j];
        ans[i+1]*=pref;
        ans[j-1]*=suff;
    }
    for(const auto& x: ans){
        cout<<x<<endl;
    }
    return 0;
}