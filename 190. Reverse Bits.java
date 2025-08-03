class Solution {
    public int reverseBits(int n) {
        long ans = 0;
        for(int i = 0; i < 32; i++){
            ans = (ans << 1) | (n & 1);
            // System.out.println((n >>> 1) & 1);
            n >>= 1;
        }

        return (int)ans;
    }
}