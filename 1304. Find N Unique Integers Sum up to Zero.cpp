class Solution {
public:
    vector<int> sumZero(int n) {
        if (n == 1) return {0};

        int num = n;
        vector<int> ans(n);
        int len = 0;

        for (int i = 0; i < n / 2; i++) {
            ans[len++] = -num;
            ans[len++] = num;
            num--;
        }

        if (n % 2 != 0) ans[len] = 0;

        return ans;
    }
};
