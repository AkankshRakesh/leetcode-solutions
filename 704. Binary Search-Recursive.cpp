class Solution {
    int ans = -1;
    public void bs(int[] nums, int left, int right, int target){
        if(left > right) return;
        int mid = left + (right - left) / 2;
        if(nums[mid] > target) bs(nums, left, mid - 1, target);
        else if(nums[mid] < target) bs(nums, mid + 1, right, target);
        else{
            ans = mid;
            return;
        }
    }
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        bs(nums, left, right, target);
        return ans;
    }
}