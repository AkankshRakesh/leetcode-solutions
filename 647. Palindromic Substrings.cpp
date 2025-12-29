class Solution {
    public boolean isPalindrome(String s){
        if(s.length() == 0) return false;
        for(int i = 0; i < s.length() / 2; i++) if(s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;

        return true;
    }
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < s.length() - i; j++){
                if(isPalindrome(s.substring(j, i + j + 1))) count++;
            }
        }

        return count;
    }
}