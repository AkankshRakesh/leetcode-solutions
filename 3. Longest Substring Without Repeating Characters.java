class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128];
        int left = 0;
        int ans = 0;
        for(int right = 0; right < s.length(); right++){
            freq[s.charAt(right)]++;

            while(freq[s.charAt(right)] >= 2){
                freq[s.charAt(left)]--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}