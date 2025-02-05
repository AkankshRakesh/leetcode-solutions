class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        int count = 0;
        int indexFirst = -1;
        int indexSecond = -1;
        for(int i = 0; i < n; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
                if(count == 1) indexFirst = i;
                else if(count == 2) indexSecond = i;
                else return false;
            };
        }
        if(count > 2 || count == 1) return false;
        if(count == 2 && (s1.charAt(indexFirst) != s2.charAt(indexSecond) || s1.charAt(indexSecond) != s2.charAt(indexFirst))) return false;
        return true;
    }
}