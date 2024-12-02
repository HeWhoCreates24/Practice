#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
int main(){
    string str;
    cout<<"enter string : ";
    getline(cin,str);
    reverse(str.begin(),str.end());
    cout<<str;
}