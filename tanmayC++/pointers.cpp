#include <iostream>
using namespace std;
int main(){
    int var = 1;
    int* ptr = &var;
    cout<<&var<<endl<<var<<endl<<ptr<<endl<<*ptr;
}