class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int prev = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int changedEle = Math.min(Math.max(nums[i] - k, prev + 1), nums[i] + k);
            if(changedEle > prev){
                count++;
                prev = changedEle;
            }
        }

        return count;
    }
}