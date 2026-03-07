class Solution {
    public boolean check(int[] nums, int target, int operations){
        for(int num : nums){
            if(num <= target) return true;
            int optNeeded = (num / target);
            if(num % target == 0) optNeeded--;
            if(optNeeded > operations) return false;
            operations -= optNeeded;
        }
        
        return true;
    }
    public void reverse(int[] nums){
        int left = 0, right = nums.length - 1;
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int max = nums[0];
        Arrays.sort(nums);
        reverse(nums);
        for(int num : nums){
            max = Math.max(max, num);
        }
        

        int left = 1, right = max;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(check(nums, mid, maxOperations)){
                right = mid - 1;
            }
            else left = mid + 1;
        }

        return left;
    }
}