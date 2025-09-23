class Solution {
    public int[] lps(String s){
        int[] lps = new int[s.length()];
        int i = 1;
        int len = 0;
        while(i < s.length()){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len != 0){
                    len = lps[len - 1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
    public boolean search(String txt, String pat){
        int[] lps = lps(pat);
        int i = 0, j = 0;
        while(i < txt.length()){
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
                if(j == pat.length()) return true;
            }
            else{
                if(j != 0) j = lps[j - 1];
                else i++;
            }
        }

        return false;
    }
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        s += s;
        return search(s, goal);
    }
}