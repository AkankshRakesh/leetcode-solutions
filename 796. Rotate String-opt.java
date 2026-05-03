class Solution {
    public boolean iterate(String s, String goal, int indexS, int indexG){
        if(indexS >= s.length()) return true;
        indexG = indexG % goal.length();
        if(s.charAt(indexS) != goal.charAt(indexG)) return false;

        return iterate(s, goal, indexS + 1, indexG + 1);
    }
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        for(int i = 0; i < goal.length(); i++){
            if(iterate(s, goal, 0, i)) return true;
        }

        return false;
    }
}