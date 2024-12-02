#include <iostream>
#include <vector>
using namespace std;
void spiralMat (const vector <vector <int >> &mat, vector <int > &arr){
    int m = mat.size(), n = mat[0].size();
    int ele = 0;
    int i = 0, j = 0;
    int box = 0;
    while (ele < m * n) {
        for (j = box; j < n - box && ele < m * n; j++) {
            arr.push_back(mat[box][j]);
            ele++;
        }
        for (i = box + 1; i < m - box && ele < m * n; i++) {
            arr.push_back(mat[i][n - box - 1]);
            ele++;
        }
        for (j = n - box - 2; j >= box && ele < m * n; j--) {
            arr.push_back(mat[m - box - 1][j]);
            ele++;
        }
        for (i = m - box - 2; i > box && ele < m * n; i--) {
            arr.push_back(mat[i][box]);
            ele++;
        }
        box++;
    }
}
int main(){
    vector <vector <int >> mat = { { 1, 2, 3, 4}, { 5, 6, 7, 8}, { 9, 10, 11, 12}};
    vector <int > arr;
    spiralMat( mat, arr);
    for (int i = 0; i < arr.size(); i++){
        cout << arr[i] << " ";
    }
    return 0;
}