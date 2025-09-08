class Solution {
public:
    bool check(int num) {
        while (num != 0) {
            if (num % 10 == 0) return false;
            num /= 10;
        }
        return true;
    }

    vector<int> getNoZeroIntegers(int n) {
        int first = n - 1;
        while (!check(first) || !check(n - first)) {
            first--;
        }
        return {first, n - first};
    }
};
