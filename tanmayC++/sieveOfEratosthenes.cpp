#include <iostream>
#include <vector>
using namespace std;
int primeCount(const int &n){
    vector <bool> primes(n,true);
    int count=0;
    for(int i=2;i<n;i++){
        if(primes[i]){
            count++;
            for(int j=i*2;j<n;j+=i){
                primes[j]=false;
            }
        }
    }
    return count;
}
int main(){
    int n;
    cin>>n;
    int count=primeCount(n);
    cout<<count;
    return 0;
}