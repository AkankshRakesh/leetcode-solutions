class Solution {
    public int moves(int[] nums, int num){
        int ans = 0;
        for(int ele : nums){
            ans += Math.abs(num - ele);
        }

        return ans;
    }
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int first = nums[nums.length / 2];
        if(nums.length % 2 == 0){
            int second = nums[(nums.length / 2) - 1];

            return Math.min(moves(nums, first), moves(nums, second));
        }

        return moves(nums, first);
    }
}