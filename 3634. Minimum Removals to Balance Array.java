class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int n = nums.length;
        int maxSize = 1;
        for(int right = 1; right < n; right++){
            while(left < right && (long) nums[left] * k < nums[right]) left++;

            maxSize = Math.max(right - left + 1, maxSize);
        }

        return n - maxSize;
    }
}