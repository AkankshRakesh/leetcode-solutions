class Solution {
public:
    vector<char> numToLetter(int num) {
        if (num == 2) return {'a', 'b', 'c'};
        else if (num == 3) return {'d', 'e', 'f'};
        else if (num == 4) return {'g', 'h', 'i'};
        else if (num == 5) return {'j', 'k', 'l'};
        else if (num == 6) return {'m', 'n', 'o'};
        else if (num == 7) return {'p', 'q', 'r', 's'};
        else if (num == 8) return {'t', 'u', 'v'};
        else return {'w', 'x', 'y', 'z'};
    }

    void backtrack(vector<string>& ans, string& curr, string& digits, int index) {
        if (index >= (int)digits.size()) {
            ans.push_back(curr);
            return;
        }

        int digit = digits[index] - '0';
        for (char ch : numToLetter(digit)) {
            curr.push_back(ch);
            backtrack(ans, curr, digits, index + 1);
            curr.pop_back();
        }
    }

    vector<string> letterCombinations(string digits) {
        vector<string> ans;
        if (digits.empty()) return ans;
        string curr;
        backtrack(ans, curr, digits, 0);
        return ans;
    }
};
