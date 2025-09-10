class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while(left < right){
            int mid = left + (right - left) / 2;
            System.out.println(mid);
            if(nums[mid] > nums[right]) left = mid + 1;
            else{
                min = Math.min(min, nums[mid]);
                right = mid;
            }
        }

        return nums[left];
    }
}