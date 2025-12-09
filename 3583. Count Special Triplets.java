class Solution {
    public int MOD = 1_000_000_007;
    public int specialTriplets(int[] nums) {
        long ans = 0;
        HashMap<Integer, Integer> freqNext = new HashMap<>();
        HashMap<Integer, Integer> freqPrev = new HashMap<>();
        for(int num : nums) freqNext.put(num, freqNext.getOrDefault(num, 0) + 1);
        for(int num : nums){
            if(freqNext.get(num) == 1) freqNext.remove(num);
            else freqNext.put(num, freqNext.get(num) - 1);

            int target = num * 2;
            if(freqPrev.containsKey(target) && freqNext.containsKey(target)){
                ans = (ans + (long) freqPrev.get(target) * freqNext.get(target)) % MOD;
            }
            freqPrev.put(num, freqPrev.getOrDefault(num, 0) + 1);
        }

        return (int)ans;
    }
}