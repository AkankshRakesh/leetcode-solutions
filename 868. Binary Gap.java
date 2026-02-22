class Solution {
    public int binaryGap(int n) {
        int ans = 0;
        int last = -1, index = 0;
        while(n != 0){
            if((n & 1) == 1){
                if(last != -1) ans = Math.max(ans, index - last);
                last = index;
            }
            index++;
            n = n >> 1;
        }

        return ans;
    }
}