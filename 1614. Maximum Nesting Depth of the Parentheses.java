class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        int curr = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') curr++;
            else if(s.charAt(i) == ')') curr--;

            ans = Math.max(ans, curr);
        }

        return ans;
    }
}