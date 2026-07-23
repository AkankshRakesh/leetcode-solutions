class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int hB = 0;
        while((1 << hB + 1) <= n) hB++;
        int res = 1 << (hB + 1);
        return res;
    }
}