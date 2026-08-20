class Solution {
    public boolean isPossible(int[] nums, int k, int target){
        int currSum = 0;
        for(int num : nums){
            currSum += num;
            if(currSum > target){
                currSum = num;
                k--;
                if(k <= 0) return false;
            }
        }
        
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int left = nums[0], right = 0;
        for(int num : nums){
            left = Math.max(left, num);
            right += num;
        }
        int sum = right;

        // binary search on value
        int ans = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(isPossible(nums, k, mid)){
                ans = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }

        return ans;
    }
}