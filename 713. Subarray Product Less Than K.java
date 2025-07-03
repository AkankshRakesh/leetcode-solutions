class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int rollingProd = 1;
        int n = nums.length;
        int ansCount = 0;
        if(k <= 1) return 0;
        for(int i = 0; i < n; i++){
            rollingProd *= nums[i];
            while(rollingProd >= k){
                rollingProd /= nums[left];
                left++;
            }
            ansCount += i - left + 1;
        }
        return ansCount;
    }
}