class Solution {
    public long flowerGame(int n, int m) {
        long nOdd = n / 2 + (n % 2 == 0 ? 0 : 1);
        long mOdd = m / 2 + (m % 2 == 0 ? 0 : 1);
        long nEven = n / 2;
        long mEven = m / 2;

        return (nOdd * mEven) + (mOdd * nEven);
    }
}