class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, mid = 0;
        while(mid <= right){
            if(nums[mid] == 2){
                int temp = nums[right];
                nums[right] = nums[mid];
                nums[mid] = temp;
                right--;
            }
            else if(nums[mid] == 0){
                int temp = nums[left];
                nums[left] = nums[mid];
                nums[mid] = temp;
                left++;
                mid++;
            }
            else mid++;
        }
    }
}