class Solution {
    public int countSubarrays(int[] nums) {
        int middleEle = nums[1];
        int left = 0;
        int count = 0;

        for(int right = 2; right < nums.length; right++){
            if((middleEle / 2 != 0) && ((double)(nums[left] + nums[right]) == ((double)middleEle / 2))) count++;
            else if(nums[left] + nums[right] == 0 && middleEle == 0)count++;
            left++;
            // System.out.println(right);
            middleEle = nums[right];

        }
        return count;
    }
}