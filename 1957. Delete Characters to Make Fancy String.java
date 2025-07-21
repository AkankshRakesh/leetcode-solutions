class Solution {
    public String makeFancyString(String s) {
        int count = 1;
        char ch = s.charAt(0);
        int n = s.length();

        StringBuilder sb = new StringBuilder(ch + "");
        for(int i = 1; i < n; i++){
            if(s.charAt(i) == ch) count++;
            else{
                count = 1;
                ch = s.charAt(i);
            }
            if(count >= 3) count--;
            else sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}