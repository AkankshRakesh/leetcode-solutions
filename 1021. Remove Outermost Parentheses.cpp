class Solution {
    public String removeOuterParentheses(String s) {
        int left = 0;
        int counter = 1;
        String ans = "";
        for(int right = 1; right < s.length(); right++){
            if(s.charAt(right) == ')') counter--;
            else counter++;

            if(counter == 0){
                left = right + 1;
                right++;
                counter = 1;
            }
            else ans += s.charAt(right);
        }
        return ans;
    }
}