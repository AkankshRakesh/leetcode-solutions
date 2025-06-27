class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int minFound = Integer.MAX_VALUE;
        while(left < right){
            int mid = left + (right - left)/2;
            if(mid - 1 >= 0 && nums[mid] < nums[mid - 1]) return nums[mid];
            else if(mid + 1 < n && nums[mid] > nums[mid + 1]) return nums[mid + 1];

            if(nums[right] < nums[mid]) left = mid + 1;
            else right = mid;
            
            if(minFound > nums[mid]) minFound = nums[mid];
        }

        return nums[left];
    }
}