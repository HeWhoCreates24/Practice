#include <iostream>
using namespace std;
int main(){
    string str;
    cout<<"enter a word..\n";
    getline(cin,str);
    int i=0;
    for(char x: str){
        char ch = tolower(x);
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
            str[i]='*';
        }
        i++;
    }
    cout<<"vowel marked word is...\n";
    cout<<str;
    return 0;
}