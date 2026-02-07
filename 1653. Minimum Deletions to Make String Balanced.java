class Solution {
    public int minimumDeletions(String s) {
        int sufCountA[] = new int[s.length()];
        int count = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            sufCountA[i] = count;
            if(s.charAt(i) == 'a') count++;
        }

        count = 0;
        int ans = s.length();
        for(int i = 0; i < s.length(); i++){
            ans = Math.min(ans, count + sufCountA[i]);
            if(s.charAt(i) == 'b') count++;
        }

        return ans;
    }
}