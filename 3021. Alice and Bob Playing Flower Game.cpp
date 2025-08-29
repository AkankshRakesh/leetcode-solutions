class Solution {
public:
    long long flowerGame(int n, int m) {
        long long nOdd = n / 2 + (n % 2 == 0 ? 0 : 1);
        long long mOdd = m / 2 + (m % 2 == 0 ? 0 : 1);
        long long nEven = n / 2;
        long long mEven = m / 2;

        return (nOdd * mEven) + (mOdd * nEven);
    }
};