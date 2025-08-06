class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0) return 0;
        int left = 0;
        HashSet<Character> hs = new HashSet<>();
        hs.add(s.charAt(0));
        int ans = 1;

        for(int right = 1; right < n; right++){
            while(hs.contains(s.charAt(right))){
                hs.remove(s.charAt(left));
                left++;
            }
            hs.add(s.charAt(right));
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}