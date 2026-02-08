class Solution {
    public boolean check(int[] freq, int k){
        int maxEle = 0, sum = 0;
        for(int i = 0; i < 26; i++){
            if(freq[i] > maxEle){
                sum += maxEle;
                maxEle = freq[i];
            }
            else sum += freq[i];
        }

        if(sum > k) return false;

        return true;
    }
    public int characterReplacement(String s, int k) {
        int left = 0;
        int ans = 0;
        int[] freq = new int[26];
        int count = 0;
        for(int right = 0; right < s.length(); right++){
            freq[s.charAt(right) - 'A']++;

            while(!check(freq, k)){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}