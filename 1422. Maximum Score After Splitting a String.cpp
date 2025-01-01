class Solution {
public:
    int maxScore(string s) {
        int ones = 0;
        int zeros = 0;
        int ans = INT_MIN;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s[i] == '1') {
                ones++;
            } else {
                zeros++;
            }
            
            ans = max(ans, zeros - ones);
        }
        
        if (s[s.length() - 1] == '1') {
            ones++;
        }
        
        return ans + ones;
    }
};