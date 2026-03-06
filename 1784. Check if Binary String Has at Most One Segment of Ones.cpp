class Solution {
    public boolean checkOnesSegment(String s) {
        int count = 0;
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) == '1'){
                while(i < s.length() && s.charAt(i) == '1') i++;
                count++;
            }
            else i++;
        }

        if(count > 1) return false;
        return true;
    }
}