#include <iostream>
#include <vector>

int main() {
    int n, k;
    std::cin >> n >> k;
    std::vector<int> fence(n);
    for (int i = 0; i < n; i++) std::cin >> fence[i];

    int sum = 0;
    int index = 0;
    for (int i = 0; i < k; i++) sum += fence[i];
    int minSum = sum;

    for (int i = k; i < n; i++) {
        sum -= fence[i - k];
        sum += fence[i];
        if (sum < minSum) {
            minSum = sum;
            index = i - k + 1;
        }
    }
    std::cout << index + 1;

    return 0;
}