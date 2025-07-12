class Solution {
public:
    void backtrack(const string& digits, int index, int n, vector<string>& arr, string curr,
                   unordered_map<char, vector<string>>& hm) {
        if (index == n) {
            if (!curr.empty()) arr.push_back(curr);
            return;
        }

        vector<string>& list = hm[digits[index]];
        for (int i = 0; i < list.size(); i++) {
            backtrack(digits, index + 1, n, arr, curr + list[i], hm);
        }
    }

    vector<string> letterCombinations(string digits) {
        vector<string> arr;
        if (digits.empty()) return arr;

        unordered_map<char, vector<string>> hm;
        for (int i = 2; i <= 9; i++) {
            vector<string> temp;
            switch (i) {
                case 2: temp = {"a", "b", "c"}; break;
                case 3: temp = {"d", "e", "f"}; break;
                case 4: temp = {"g", "h", "i"}; break;
                case 5: temp = {"j", "k", "l"}; break;
                case 6: temp = {"m", "n", "o"}; break;
                case 7: temp = {"p", "q", "r", "s"}; break;
                case 8: temp = {"t", "u", "v"}; break;
                case 9: temp = {"w", "x", "y", "z"}; break;
            }
            hm['0' + i] = temp;  // Convert int to char: e.g., 2 → '2'
        }

        backtrack(digits, 0, digits.length(), arr, "", hm);
        return arr;
    }
};
