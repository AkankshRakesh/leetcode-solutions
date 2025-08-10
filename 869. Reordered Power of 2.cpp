class Solution {
public:
    bool reorderedPowerOf2(int n) {
        string s = to_string(n);
        sort(s.begin(), s.end());
        vector<bool> used(s.size(), false);
        string current = "";
        return backtrack(s, used, current);
    }

private:
    bool backtrack(const string& digits, vector<bool>& used, string& current) {
        if ((int)current.size() == (int)digits.size()) {
            if (current[0] == '0') return false;
            int val = stoi(current);
            return isPowerOfTwo(val);
        }

        for (int i = 0; i < (int)digits.size(); i++) {
            if (i > 0 && digits[i] == digits[i - 1] && !used[i - 1]) continue;
            if (!used[i]) {
                used[i] = true;
                current.push_back(digits[i]);
                if (backtrack(digits, used, current)) return true;
                current.pop_back();
                used[i] = false;
            }
        }
        return false;
    }

    bool isPowerOfTwo(int x) {
        return x > 0 && (x & (x - 1)) == 0;
    }
};
