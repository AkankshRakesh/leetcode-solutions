class Solution {
    public int countBinarySubstrings(String s) {
        int ans = 0, prev = 0, curr = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++;
            } else {
                ans += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
        }

        ans += Math.min(prev, curr);
        return ans;
    }
}