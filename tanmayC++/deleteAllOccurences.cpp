#include <iostream>
#include <string>
using namespace std;
void deleteOccur(string &str,const string &sub){
    while(str.find(sub)<str.size()){
        str.erase(str.find(sub),sub.size());
    }
}
int main(){
    string str,sub;
    getline(cin,str);
    getline(cin,sub);
    deleteOccur(str,sub);
    cout<<str;
}