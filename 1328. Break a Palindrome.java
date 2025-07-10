class Solution {
    public boolean isPalin(String s){
        int n = s.length();
        int left = 0, right = n - 1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    public String breakPalindrome(String palindrome) {
        boolean foundNonA = false;
        StringBuilder sb = new StringBuilder("");
        int n = palindrome.length();
        if(n == 1) return "";

        for(int i = 0; i < n; i++){
            if(palindrome.charAt(i) != 'a' && !foundNonA){
                foundNonA = true;
                sb.append('a');
            }
            else sb.append(palindrome.charAt(i));
        }
        // System.out.println(isPalin("aaccba"));
        if(isPalin(sb.toString()) || !foundNonA){
            sb = new StringBuilder(palindrome);
            sb.setCharAt(n - 1, 'b');
        }

        return sb.toString();
    }
}