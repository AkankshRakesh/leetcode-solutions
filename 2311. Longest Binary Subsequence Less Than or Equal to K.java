class Solution {
    public int longestSubsequence(String s, int k) {
        int count = 0;
        int n = s.length();
        int currInt = 0, currInd = 0;
        boolean flag = false;

        for(int i = n - 1; i >= 0; i--){
            if(currInt >= k) flag = true;

            if(s.charAt(i) == '1' && !flag){
                currInt += Math.pow(2, currInd);
                // System.out.println(currInt);
                if(currInt >= k){
                    flag = true;
                    if(currInt != k) continue;
                }
                count++;
            }
            else if(s.charAt(i) == '0') count++;

            currInd++;
        }
        return count;
    }
}