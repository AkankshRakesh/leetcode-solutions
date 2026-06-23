class Solution {
    public boolean validSubStr(int[] freq){
        for(int i = 0; i < 128; i++) if(freq[i] > 0) return false;
        return true;
    }
    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        for(int i = 0; i < t.length(); i++) freq[t.charAt(i)]++;

        String ans = "";
        StringBuilder sb = new StringBuilder();
        int left = 0;
        for(int right = 0; right < s.length(); right++){
            freq[s.charAt(right)]--;
            sb.append(s.charAt(right));

            while(validSubStr(freq)){
                if(ans.length() == 0 || ans.length() > sb.length()) ans = sb.toString();
                freq[s.charAt(left)]++;
                sb.deleteCharAt(0);
                left++;
            }
        }

        return ans;
    }
}