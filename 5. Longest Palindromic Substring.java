class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder("#");
        for(int i = 0; i < s.length(); i++) sb.append(s.charAt(i)).append("#");

        int ansLen = 0;
        int ansCenter = 0;
        for(int i = 0; i < sb.length(); i++){
            int left = i - 1, right = i + 1;
            int len = sb.charAt(i) == '#' ? 0 : 1;

            while(left >= 0 && right < sb.length() && sb.charAt(left) == sb.charAt(right)){
                if(sb.charAt(left) != '#') len += 2;
                left--;
                right++;
            }
            if(len > ansLen){
                ansCenter = i;
                ansLen = len;
            }
        }

        // System.out.println(ansCenter);
        int start = ansCenter - ansLen;
        int end = ansCenter + ansLen;
        StringBuilder result = new StringBuilder();

        for (int i = start; i <= end; i++) {
            if (sb.charAt(i) != '#') {
                result.append(sb.charAt(i));
            }
        }

        return result.toString();
    }
}