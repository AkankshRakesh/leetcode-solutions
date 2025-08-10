class Solution {
    public int trap(int[] nums) {
        int left = 0;
        int n = nums.length;
        int right = n - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;
        while (left < right) {
            if (nums[left] < nums[right]) {
                if (nums[left] >= leftMax) {
                    leftMax = nums[left];
                } else {
                    water += leftMax - nums[left];
                }
                left++;
            } else {
                if (nums[right] >= rightMax) {
                    rightMax = nums[right];
                } else {
                    water += rightMax - nums[right];
                }
                right--;
            }
        }

        return water;
    }
}