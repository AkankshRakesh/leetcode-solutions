class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length(), m = goal.length();
        if(n != m) return false;
        s += s;
        n = s.length();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == goal.charAt(0)){
                if(i + m < n){
                    String temp = s.substring(i, i + m);
                    if(temp.equals(goal)) return true;
                }
            }
        }
        return false;
    }
}