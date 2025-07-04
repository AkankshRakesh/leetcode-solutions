class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int n = nums.length;
        int countZero = 0;
        int maxLen = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] == 0) countZero++;

            while(countZero > k){
                if(nums[left] == 0) countZero--;
                left++;
            }

            int windowSize = i - left + 1;
            if(maxLen < windowSize) maxLen = windowSize;
        }

        return maxLen;
    }
}