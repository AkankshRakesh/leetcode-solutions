class Solution {
    public int search(int[] nums, int target) {
        // if mid < left && mid < right = valid bottom, go left
        // else go min(left, right)

        int left = 0, right = nums.length - 1;
        int pivotIndex = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[nums.length - 1]) {
                left = mid + 1;
            } else {
                pivotIndex = mid;
                right = mid - 1;
            }
        }

        // System.out.println(pivotIndex);
        left = pivotIndex;
        right = pivotIndex + nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int index = mid % nums.length;
            
            if(nums[index] < target) left = mid + 1;
            else if(nums[index] > target) right = mid - 1;
            else return index;
        }
        
        return -1;
    }
}