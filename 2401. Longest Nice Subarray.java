class Solution {
    public int longestNiceSubarray(int[] nums) {
        int max = 1, left = 0, currMask = 0;

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];

            for (; (currMask & num) != 0; left++) {
                currMask ^= nums[left]; 
            }

            currMask |= num;
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
