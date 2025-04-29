class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxEle = nums[0];
        for(int num : nums) maxEle = num > maxEle ? num : maxEle;

        long count = 0;
        long countOfMaxEle = 0;
        int n = nums.length;
        int j = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == maxEle) countOfMaxEle++;
            while(countOfMaxEle >= k){
                if(nums[j] == maxEle) countOfMaxEle--;  
                j++;
            }
            count += j;
        }
        return count;
    }
}