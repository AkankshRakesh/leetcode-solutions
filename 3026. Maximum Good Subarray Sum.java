class Solution {
    // class Pair{
    //     Integer index;
    //     Long sum;
    //     public Pair(Integer index, Long sum){
    //         this.index = index;
    //         this.sum = sum;
    //     }
    // }
    public long maximumSubarraySum(int[] nums, int k) {
        int left = 0;
        long ans = Long.MIN_VALUE;
        HashMap<Integer, Long> hm = new HashMap<>();
        int n = nums.length;

        long currSum = 0;
        for(int i = 0; i < n; i++){
            currSum += nums[i];
            if(hm.containsKey(nums[i] - k) && ans < currSum - hm.get(nums[i] - k)) ans = currSum - hm.get(nums[i] - k);
            if(hm.containsKey(nums[i] + k) && ans < currSum - hm.get(nums[i] + k)) ans = currSum - hm.get(nums[i] + k); 

            hm.put(nums[i], Math.min(hm.getOrDefault(nums[i], Long.MAX_VALUE), currSum - nums[i]));

        }
        return ans == Long.MIN_VALUE ? 0 : ans;
    }
}