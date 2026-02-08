class Solution {
    public int numberOfSubstrings(String s, int k) {
        int ans = 0;
        int count = 0;

        for(int left = 0; left < s.length(); left++){
            int[] freq = new int[128];
            int right = left;
            for(right = left; right < s.length(); right++){
                freq[s.charAt(right)]++;
                if(freq[s.charAt(right)] == k) break;
            }
            ans += s.length() - right;
        }

        return ans;
    }
}