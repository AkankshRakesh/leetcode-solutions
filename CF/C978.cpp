#include <iostream>
#include <vector>

int main() {
    long long n, m;
    std::cin >> n >> m;
    std::vector<long long> buildings(n);
    for (int i = 0; i < n; i++) std::cin >> buildings[i];

    int index = 0;
    long long currSum = 0;
    for (int i = 0; i < m; i++) {
        long long room;
        std::cin >> room;
        while (index < n && buildings[index] + currSum < room) {
            currSum += buildings[index];
            index++;
        }
        if (room > currSum) room -= currSum;
        std::cout << (index + 1) << " " << room << "\n";
    }

    return 0;
}