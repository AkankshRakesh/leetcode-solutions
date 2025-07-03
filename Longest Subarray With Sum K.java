public class Solution {
    public static int longestSubarrayWithSumK(int []nums, long k) {
        int left = 0;
        long rollingSum = 0;
        int maxCount = Integer.MIN_VALUE;
        int count = 0;
        for(int num: nums){
            rollingSum += num;
            count++;
            while(rollingSum > k){
                rollingSum -= nums[left];
                left++;
                count--;
            }

            if(maxCount < count && rollingSum == k) maxCount = count;
        }
        if(maxCount < count && rollingSum == k) maxCount = count;

        return maxCount;
    }
}