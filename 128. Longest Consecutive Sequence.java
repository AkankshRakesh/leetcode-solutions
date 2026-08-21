class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums) hs.add(num);
        
        int ans = 0;
        for(int num : nums){
            if(!hs.contains(num)) continue;
            int left = num - 1, right = num + 1;

            while(hs.contains(left)){
                hs.remove(left);
                left--;
            }
            
            while(hs.contains(right)){
                hs.remove(right);
                right++;
            }

            hs.remove(num);
            ans = Math.max(ans, 1 + (num - left - 1) + (right - num - 1));
        }

        return ans;
    }
}