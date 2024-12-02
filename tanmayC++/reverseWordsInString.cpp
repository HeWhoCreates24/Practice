#include <iostream>
#include <string>
using namespace std;
void reverseWords(string &str){
    string rev,word;
    char prev=' ';
    for(int i=0;i<str.length();i++){
        if(prev==' '&&str[i]==' '){
            continue;
        }
        else if(prev==' '){
            rev=word+rev;
            word.clear();
            word=word+str[i];
        }
        else{
            word=word+str[i];
        }
        prev=str[i];
    }
    str=word+' '+rev;
}
int main(){
    string str;
    getline(cin,str);
    reverseWords(str);
    cout<<str;
    return 0;
}