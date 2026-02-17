class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int sum = 0;
        int ans = 0;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(nums[i] == 0) sum -= 1;

            if(!hm.containsKey(sum)) hm.put(sum, i);
            else{
                ans = Math.max(ans, i - hm.get(sum));
            }
        }

        return ans;
    }
} 