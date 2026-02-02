class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] freq = new int[128];
        int count = 0;
        int ans = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++){
            freq[s.charAt(right)]++;
            if(freq[s.charAt(right)] == 1) count++;
            if(count > 2 && left < right){
                freq[s.charAt(left)]--;
                if(freq[s.charAt(left++)] == 0) count--;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}