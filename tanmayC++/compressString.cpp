#include <iostream>
#include <string>
using namespace std;
void compress(string &str){
    int n=str.length();
    int index=0;
    for(int i=0;i<n;){
        char ch=str[i];
        int count=0;
        while(i<n&&str[i]==ch){
            count++;
            i++;
        }
        if(count==1){
            str[index++]=ch;
        }
        else{
            str[index++]=ch;
            string num=to_string(count);
            for(char x: num){
                str[index++]=x;
            }
        }

    }
    str.resize(index);
}
int main(){
    string str;
    getline(cin,str);
    compress(str);
    cout<<str;
    return 0;
}