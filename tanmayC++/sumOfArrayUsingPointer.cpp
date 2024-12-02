#include <iostream>
using namespace std;
/* 
This is crazzy....
arrays....pointers...references...
ALL ARE F*C*I*G SAMEEEE;
*/
int* intArr(int s){
    int* arr = new int[s];
    cout<<"enter "<<s<<" elements"<<endl;
    for(int i = 0; i < s; i++){
        cout<<i+1<<" -> ";
        cin>>*(arr+i);
    }
    int* ar = &(*arr);
    return ar;
}
int arrSum(int* arr,int s){
    int sum = 0;
    for(int i=0;i<s;i++){
        sum += arr[i];
    }
    return sum;
}
int main(){
    int size;
    cout<<"enter size of array : ";
    cin>>size;
    int* arr = intArr(size);
    int sum = arrSum(arr,size);
    cout<<sum;
    delete[] arr;
    return 0;
}