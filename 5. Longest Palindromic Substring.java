class Solution {
    public int[] expand(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return new int[]{left + 1, right - 1};
    }
    public String longestPalindrome(String s) {
        int len = 0, ansLeft = 0, ansRight = 0;
        for(int i = 1; i < s.length(); i++){
            int[] boundary1 = expand(s, i - 1, i + 1);
            int[] boundary2 = new int[2];
            if(s.charAt(i) == s.charAt(i - 1)) boundary2 = expand(s, i - 2, i + 1);
            int len1 = boundary1[1] - boundary1[0];
            int len2 = boundary2[1] - boundary2[0];
            if(len < len1 || len < len2){
                if(len1 < len2){
                    len = len2;
                    ansLeft = boundary2[0];
                    ansRight = boundary2[1];
                }
                else{
                    len = len1;
                    ansLeft = boundary1[0];
                    ansRight = boundary1[1];
                }
            }
        }

        return s.substring(ansLeft, ansRight + 1);   
    }
}