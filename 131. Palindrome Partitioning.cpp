class Solution {
public:
    bool isPalin(const string& s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s[left] != s[right]) return false;
            left++;
            right--;
        }
        return true;
    }

    void backtracking(const string& s, vector<vector<string>>& arr, vector<string>& currArr, int index, int n) {
        if (index == n) {
            arr.push_back(currArr);
            return;
        }

        for (int i = index + 1; i <= n; i++) {
            string substr = s.substr(index, i - index);
            if (isPalin(substr)) { 
                currArr.push_back(substr);
                backtracking(s, arr, currArr, i, n);
                currArr.pop_back(); // backtrack
            }
        }
    }

    vector<vector<string>> partition(string s) {
        vector<vector<string>> arr;
        vector<string> currArr;
        backtracking(s, arr, currArr, 0, s.length());
        return arr;
    }
};
