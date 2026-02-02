class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        boolean[] check = new boolean[256];
        int ans = 0;

        for(int right = 0; right < s.length(); right++){
            while(check[s.charAt(right)]){
                check[s.charAt(left)] = false;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            check[s.charAt(right)] = true;
        }

        return ans;
    }
}