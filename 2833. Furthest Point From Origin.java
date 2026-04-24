class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int ans = 0, count = 0;
        for(char ch : moves.toCharArray()){
            if(ch == 'L') ans--;
            else if(ch == 'R') ans++;
            else count++;
        }
        if(ans < 0) return Math.abs(ans - count);
        return ans + count;
    }
}