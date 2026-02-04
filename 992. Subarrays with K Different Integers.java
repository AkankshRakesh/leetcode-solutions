class Solution {
    public int solve(int[] nums, int k){
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int left = 0;
        int count = 0;
        for(int right = 0; right < nums.length; right++){
            hm.put(nums[right], hm.getOrDefault(nums[right], 0) + 1);

            while(hm.size() > k){
                hm.put(nums[left], hm.get(nums[left]) - 1);
                if(hm.get(nums[left]) == 0) hm.remove(nums[left]);
                
                left++;
            }

            ans += right - left;
        }

        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums, k) - solve(nums, k - 1);
    }
}