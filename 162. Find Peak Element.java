class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        if(n == 2) return nums[0] > nums[1] ? 0 : 1;
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(mid > 0 && mid < n - 1){
                if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
                else if(nums[mid] <= nums[mid + 1]) left = mid + 1;
                else right = mid;
            }
            else break;
        }
        if(nums[n - 2] < nums[n - 1]) return n - 1;
        if(nums[0] > nums[1]) return 0;
        return -1;
    }
}