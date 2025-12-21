class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        unordered_set<int> dontCheck;
        int ans = 0;

        for (int i = 0; i < strs[0].length(); i++) {
            unordered_set<int> copy = dontCheck;

            for (int j = 0; j < strs.size() - 1; j++) {
                if (dontCheck.count(j)) continue;

                if (strs[j][i] < strs[j + 1][i]) {
                    dontCheck.insert(j);
                }
                else if (strs[j][i] > strs[j + 1][i]) {
                    ans++;
                    dontCheck = copy;
                    break;
                }
            }
        }

        return ans;
    }
};
