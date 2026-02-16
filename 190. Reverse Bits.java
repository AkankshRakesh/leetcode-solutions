class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        int count = 31;
        while(count != 0){
            int bit = n & 1;
            // System.out.print(bit);
            ans = ans | bit;
            ans = ans << 1;
            n = n >> 1;
            count--;
        }

        return ans;
    }
}