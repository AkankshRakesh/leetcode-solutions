class Solution {
    public int minOperations(int[] nums, int x) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int sum = 0;

        for(int i = 0; i < nums.length && sum <= x; i++){
            sum += nums[i];
            hm.put(sum, i);
        }

        int ans = hm.containsKey(x) ? hm.get(x) + 1 : Integer.MAX_VALUE;

        sum = 0;
        for(int i = nums.length - 1; i >= 0 && sum <= x; i--){
            sum += nums[i];
            if(hm.containsKey(x - sum) && hm.get(x - sum) < i) ans = Math.min(ans, hm.get(x - sum) + 1 + (nums.length - i));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}