class Solution {
    bool flag = false;

    void carrySum(vector<int>& digits, int ind) {
        if (ind < 0) {
            flag = true;
            return;
        }
        if (digits[ind] == 9) {
            digits[ind] = 0;
            carrySum(digits, ind - 1);
        } else {
            digits[ind]++;
        }
    }

public:
    vector<int> plusOne(vector<int>& digits) {
        carrySum(digits, digits.size() - 1);

        if (flag) {
            vector<int> ans(digits.size() + 1, 0);
            ans[0] = 1;
            return ans;
        }

        return digits;
    }
};
