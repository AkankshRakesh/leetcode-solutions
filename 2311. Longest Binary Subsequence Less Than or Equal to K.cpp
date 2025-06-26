class Solution {
public:
    int longestSubsequence(std::string s, int k) {
        int count = 0;
        int n = s.length();
        int currInt = 0, currInd = 0;
        bool flag = false;

        for (int i = n - 1; i >= 0; --i) {
            if (currInt >= k) flag = true;

            if (s[i] == '1' && !flag) {
                currInt += std::pow(2, currInd);
                if (currInt >= k) {
                    flag = true;
                    if (currInt != k) continue;
                }
                count++;
            }
            else if (s[i] == '0') {
                count++;
            }

            currInd++;
        }
        return count;
    }
};
