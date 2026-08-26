class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        StringBuilder sb = new StringBuilder();
        String ans = "";
        int count = 0;
        int left = 0;
        int ansLen = Integer.MAX_VALUE;

        for(int right = 0; right < s.length(); right++){
            if(s.charAt(right) == '1') count++;
            sb.append(s.charAt(right));

            while(count >= k){
                if(count == k && right - left + 1 < ansLen){
                    ans = sb.toString();
                    ansLen = right - left + 1;
                }
                else if(count == k && right - left + 1 == ansLen){
                    String curr = sb.toString();
                    if(ans.compareTo(curr) == 1) ans = curr;
                }

                sb.deleteCharAt(0);
                if(s.charAt(left) == '1') count--;
                left++;
            }
        }

        return ans;
    }
}