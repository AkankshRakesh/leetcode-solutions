class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        vector<bool> check(strs[0].length(), true);

        for (int i = 1; i < strs.size(); i++) {
            string past = strs[i - 1];
            string curr = strs[i];
            for (int j = 0; j < past.length(); j++) {
                if (past[j] > curr[j]) check[j] = false;
            }
        }

        int count = 0;
        for (bool val : check)
            if (!val) count++;

        return count;
    }
};
