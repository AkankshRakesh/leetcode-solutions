class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i = 0; i < n; i++) if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) sb.append(Character.toLowerCase(s.charAt(i)));

        n = sb.length();
        for(int i = 0; i < n / 2; i++){
            if(sb.charAt(i) != sb.charAt(n - 1 - i)) return false;
        }

        return true;
    }
}