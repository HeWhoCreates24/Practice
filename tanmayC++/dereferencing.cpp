#include <iostream>
using namespace std;
int main(){
    int var;
    cout<<"enter a number : ";
    cin>>var;
    int* ptr = &var;    //assigning the addres of the variable to a pointer
    *ptr *= 2;          //dereferencing the variable through the pointer and operating on its value
    cout<<var;
    return 0;
}