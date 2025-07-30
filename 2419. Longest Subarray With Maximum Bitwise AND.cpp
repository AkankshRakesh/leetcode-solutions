class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;

        int maxNum = nums[0];
        for(int num : nums) if(num > maxNum) maxNum = num;

        int maxSize = 1;
        for(int left = 0; left < n; left++){
            int right = left + 1;
            if(nums[left] != maxNum) continue;
            while(left < right && right < n && nums[right] == maxNum){
                if(maxSize < right - left + 1) maxSize = right - left + 1;
                right++;
            }
            left = right;
        }

        return maxSize;
    }
}