class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        boolean ansFound = false;
        int left = 0;
        int rollingSum = 0;
        int n = nums.length;
        int minNum = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            rollingSum += nums[i];
            while(rollingSum >= target){
                ansFound = true;
                int len = i - left + 1;
                if(minNum > len) minNum = len;
                rollingSum -= nums[left];
                left++;
            }
        }
        if(rollingSum >= target){
            int len = n - left;
            if(minNum > len) minNum = len;
        }
        if(!ansFound) return 0;
        return minNum;
    }
}