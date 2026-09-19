class Solution {
    public String expand(String s, int left, int right){
        int index = -1;
        if(right - left > 1) index = left + 1;
        StringBuilder sb = new StringBuilder();

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            sb.append(s.charAt(right));
            left--;
            right++;
        }

        StringBuilder ans = new StringBuilder(sb).reverse();
        if(index != -1) ans.append(s.charAt(index));
        ans.append(sb);

        return ans.toString();
    }
    public String longestPalindrome(String s) {
        if(s.length() == 1) return s;
        String ans = "";

        for(int i = 0; i < s.length() - 1; i++){
            String evenPal = "";
            if(s.charAt(i) == s.charAt(i + 1)){
                evenPal = expand(s, i, i + 1);
            }

            String oddPal = expand(s, i - 1, i + 1);

            if(oddPal.length() > evenPal.length() && oddPal.length() > ans.length()) ans = oddPal;
            else if(evenPal.length() > ans.length()) ans = evenPal; 
        }

        return ans;
    }
}