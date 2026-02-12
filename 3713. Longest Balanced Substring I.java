class Solution {
    public boolean check(int[] freq){
        int past = -1;
        for(int i = 0; i < 28; i++){
            if(freq[i] != 0){
                if(past == -1) past = freq[i];
                else if(past != freq[i]) return false;
            }
        }

        return true;
    }
    public int longestBalanced(String s) {
        int ans = 1;
        for(int i = 0; i < s.length(); i++){
            int[] freq = new int[28];
            for(int j = i; j < s.length(); j++){
                freq[s.charAt(j) - 'a']++;
                if(check(freq)){
                    ans = Math.max(j - i + 1, ans);
                }
            }
        }

        return ans;
    }
}