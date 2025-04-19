class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;

        for(int i = 0; i < nums.length; i++) {
            int low = lower - nums[i];
            int high = upper - nums[i];
            
            int left = lowerBound(nums, low, i + 1);
            int right = upperBound(nums, high, i + 1);
            
            count += right - left;
        }
        return count;
    }

    private int lowerBound(int[] nums, int target, int start) {
        int left = start, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int upperBound(int[] nums, int target, int start) {
        int left = start, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
