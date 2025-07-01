class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0;
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') count++;
            else count--;

            if(count < 0){
                ans++;
                count = 0;
            }
        }
        if(count < 0) return ans;
        else return ans + count;
    }
}