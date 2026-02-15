class Solution {
    public int subarraySumLessThanEqualToK(int[] nums, int k){
        int left = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        int ans = 0;
        int sum = 0;
        freq.put(0, 1);
        
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            if(freq.containsKey(sum - k)){
                ans += freq.get(sum - k);
            }
            
            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }
        // System.out.println(ans);

        return ans;
    }
    public int subarraySum(int[] nums, int k) {
        return subarraySumLessThanEqualToK(nums, k);
    }
}