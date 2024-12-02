#include <iostream>
using namespace std;

int main() {
    int n;
    cout << "Enter n: ";
    cin >> n;

    if (n <= 0) {
        cout << "Please enter a positive integer." << endl;
        return 0;
    } else if (n == 1) {
        cout << 0 << endl;
        return 0;
    } else if (n == 2) {
        cout << 1 << endl;
        return 0;
    }

    int first = 0;
    int second = 1;
    int current;

    for (int i = 2; i < n; i++) {
        current = first + second;
        first = second;
        second = current;
    }

    cout << current << endl;
    return 0;
}
