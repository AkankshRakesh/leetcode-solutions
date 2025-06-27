class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(mid > 0 && mid < n - 1){
                if(nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) left = mid + 1;
                else right = mid;
            }
            else return nums[left] > nums[right] ? nums[left] > nums[mid] ? left : mid : nums[right] > nums[mid] ? right : mid;
        }
        return left;
    }
}