#include <iostream>
using namespace std;
int main(){
    int n;
    cout<<"enter size of array : ";
    cin>>n;
    int* arr = new int[n];//allocating dynamically an array
    int mx=INT_MIN;
    cout<<"enter elements of array"<<endl;
    for(int i = 0;i<n;i++){
        int temp;
        cout<<i+1<<" -> ";
        cin>>temp;
        *(arr+i)=temp;
        mx=max(temp,mx);
    }
    cout<<"max in array is : "<<mx;
    delete[] arr;//freeing the allocated memory
    return 0;
}