class Solution {
    public int findMin(int[] nums) {
        return dnc(0, nums.length - 1, nums);
    }

    int dnc(int left, int right, int[] nums) {
        if (left == right)
            return nums[left];

        if (nums[left] < nums[right])
            return nums[left];

        int m = (left + right) >> 1;

        return Math.min(dnc(left, m, nums), dnc(m + 1, right, nums));
    }
}