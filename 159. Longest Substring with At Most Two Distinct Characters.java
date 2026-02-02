class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0) return 0;
        int[] freq = new int[128];
        int left = 0;
        int ans = 0;
        int count = 0;

        for(int right = 0; right < s.length(); right++){
            freq[s.charAt(right)]++;
            if(freq[s.charAt(right)] == 1) count++;
            while(count > k && left < right){
                freq[s.charAt(left)]--;
                if(freq[s.charAt(left++)] == 0) count--;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
