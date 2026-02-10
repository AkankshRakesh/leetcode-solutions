class Solution {
    public int longestBalanced(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            HashSet<Integer> hs = new HashSet<>();
            int even = 0, odd = 0;
            hs.add(nums[i]);
            if((nums[i] & 1) == 0) even++;
            else odd++;

            for(int j = i + 1; j < nums.length; j++){
                if(!hs.contains(nums[j])){
                    hs.add(nums[j]);
                    if((nums[j] & 1) == 0) even++;
                    else odd++;
                }
                if(even == odd) ans = Math.max(ans, j - i + 1);
            }
        }

        return ans;
    }
}