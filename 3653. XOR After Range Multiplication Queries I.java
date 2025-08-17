class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int MOD = 1_000_000_007;

        for(int[] q : queries){
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];

            for(int i = l; i <= r; i += k){
                nums[i] = (int)((nums[i] * (long)v) % MOD);
            }
        }

        int xor = 0;
        for(int num : nums) xor ^= num;

        return xor;
    }
}