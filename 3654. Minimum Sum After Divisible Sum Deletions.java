class Solution {
    public long minArraySum(int[] nums, int k) {
        long totalSum = 0;
        for(int num : nums) totalSum += num;

        long dp = 0;
        HashMap<Integer, Long> hm = new HashMap<>();
        hm.put(0, 0L);
        long ps = 0;
        long mr = 0;

        for(int num: nums){
            ps += num;
            dp += num;
            int mod = (int)(ps % k);
            if(hm.containsKey(mod)){
                dp = Math.min(dp, hm.get(mod));
            }
            hm.put(mod, Math.min(hm.getOrDefault(mod, Long.MAX_VALUE), dp));
        }
        
        return dp;
    }
}
// 3 - 11407, 4 - 1527