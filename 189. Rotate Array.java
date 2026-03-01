class Solution {
    public void reverse(int[] nums, int left, int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    public void rotate(int[] nums, int k) { 
        reverse(nums, 0, nums.length - 1);
        k %= nums.length;
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
}