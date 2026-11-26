class Solution {
    private final int MOD = 1_000_000_007;
    public boolean check(int[] nums, int size, long[] h, long[] p){
        HashMap<Long, Integer> hm = new HashMap<>();
        for(int i = 0; i + size <= nums.length; i++){
            int right = i + size;
            long key = (h[right] - ((h[i] * p[size]) % MOD) + MOD) % MOD;
            hm.put(key, hm.getOrDefault(key, 0) + 1);
        }

        for(int times : hm.values()){
            if(times == 1) return true;
        }

        return false;
    }
    public int smallestUniqueSubarray(int[] nums) {
        long[] h = new long[nums.length + 1];
        long[] p = new long[nums.length + 1];
        p[0] = 1;

        for(int i = 0; i < nums.length; i++){
            h[i + 1] = (h[i] * 911382323L + nums[i]) % MOD;
            p[i + 1] = (p[i] * 911382323L) % MOD;
        }
        
        int left = 1, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(check(nums, mid, h, p)){
                right = mid - 1;
            }
            else left = mid + 1;
        }

        return left;
    }
}