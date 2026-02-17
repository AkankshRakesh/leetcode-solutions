class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int ans = 0;
        hm.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) sum--;
            sum += nums[i];

            // System.out.println(sum);
            if(hm.containsKey(sum)) ans = Math.max(ans, i - hm.get(sum));
            else hm.put(sum, i);
        }

        return ans;
    }
}