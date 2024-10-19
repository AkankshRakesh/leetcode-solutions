class Solution {
public:
    char findKthBit(int n, int k) {
        vector<int> arr(n);
        arr[0] = 1;
        for (int i = 1; i < n; i++) {
            arr[i] = 2 * arr[i - 1] + 1;
        }
        return findDigit(k - 1, n - 1, arr);
    }

private:
    char findDigit(int i, int n, vector<int>& arr) {
        if (n == 0) {
            return '0';
        }
        int mid = (arr[n] - 1) / 2;
        if (i == mid) {
            return '1';
        } else if (i < mid) {
            return findDigit(i, n - 1, arr);
        } else {
            return findDigit(mid - (i - mid), n - 1, arr) == '0' ? '1' : '0';
        }
    }
};