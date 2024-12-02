#include <iostream>
using namespace std;

int main() {
    int n;
    cout << "Enter size of array: ";
    cin >> n;
    int a[n];
    
    cout << "Enter the elements of the array...\n";
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }

    bool swapped;
    int m=n;
    do {
        swapped = false;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
                swapped = true;
            }
        }
        n--;
    } while (swapped);
    
    cout << "Sorted array is..." << endl;
    for (int i = 0; i < m; i++) {
        cout << a[i] << endl;
    }

    return 0;
}
