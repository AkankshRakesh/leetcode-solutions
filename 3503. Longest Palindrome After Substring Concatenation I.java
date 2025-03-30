public class Solution {
    public int longestPalindrome(String s, String t) {
        int maxLen = 0;
        
        // Check all substrings of s
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (isPalindrome(sub)) {
                    maxLen = Math.max(maxLen, sub.length());
                }
            }
        }
        
        // Check all substrings of t
        for (int i = 0; i < t.length(); i++) {
            for (int j = i + 1; j <= t.length(); j++) {
                String sub = t.substring(i, j);
                if (isPalindrome(sub)) {
                    maxLen = Math.max(maxLen, sub.length());
                }
            }
        }
        
        // Check all concatenations of substrings from s and t
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sSub = s.substring(i, j);
                for (int k = 0; k < t.length(); k++) {
                    for (int l = k + 1; l <= t.length(); l++) {
                        String tSub = t.substring(k, l);
                        String combined = sSub + tSub;
                        if (isPalindrome(combined)) {
                            maxLen = Math.max(maxLen, combined.length());
                        }
                    }
                }
            }
        }
        
        return maxLen;
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}