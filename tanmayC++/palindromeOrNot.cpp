#include <iostream>
#include <string>
using namespace std;
bool isPalindrome(const string &str){
    int i=0,j=str.length()-1;
    while(i<j){
        if(tolower(str[i++])!=tolower(str[j--])) return false;
    }
    return true;
}
int main(){
    string str;
    cout<<"enter a word : ";
    getline(cin,str);
    if(isPalindrome(str)) cout<<"is a palindrome";
    else cout<<"is not a palindrome";
    return 0;
}