class Solution {
public:
    string shortestBeautifulSubstring(string s, int k) {
        string sb = "";
        string ans = "";
        int count = 0;
        int left = 0;
        int ansLen = INT_MAX;

        for (int right = 0; right < s.length(); right++) {
            if (s[right] == '1') count++;
            sb += s[right];

            while (count >= k) {
                if (count == k && right - left + 1 < ansLen) {
                    ans = sb;
                    ansLen = right - left + 1;
                }
                else if (count == k && right - left + 1 == ansLen) {
                    string curr = sb;
                    if (ans.compare(curr) == 1) ans = curr;
                }

                sb.erase(0, 1);
                if (s[left] == '1') count--;
                left++;
            }
        }

        return ans;
    }
};