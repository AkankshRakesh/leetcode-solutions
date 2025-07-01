class Solution {
    public int possibleStringCount(String word) {
        int ans = 1;
        char currChar = word.charAt(0);
        int currCount = 1;
        for(int i = 1; i < word.length(); i++){
            if(word.charAt(i) == currChar) currCount++;
            else{
                ans += currCount - 1;
                currCount = 1;
                currChar = word.charAt(i);
            }
        }
        ans += currCount - 1;
        return ans;
    }
}