class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean allZero = true;
        for(int num : nums){
            if(num != 0) allZero = false;
            xor ^= num;
        }

        if(allZero) return 0;
        if(xor == 0) return nums.length - 1;
        return nums.length;
    }
}