class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums) hs.add(num);
        int ans = 0;

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(!hs.contains(num)) continue;

            int left = num - 1;
            int countLeft = 0;
            while(hs.contains(left)){
                hs.remove(left);
                left--;
                countLeft++;
            }

            int right = num + 1;
            int countRight = 0;
            while(hs.contains(right)){
                hs.remove(right);
                right++;
                countRight++;
            }

            ans = Math.max(ans, countLeft + 1 + countRight);
            hs.remove(num);
        }

        return ans;
    }
}