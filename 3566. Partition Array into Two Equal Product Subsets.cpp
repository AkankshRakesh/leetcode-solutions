class Solution {
    public boolean backtrack(int[] nums, int index, long target, HashSet<Integer> hs, long curr){
        if(curr > target) return false;
        if(curr == target) return true;
        if(index >= nums.length) return false;

        // System.out.println(curr);
        boolean add = backtrack(nums, index + 1, target, hs, curr * nums[index]);
        if(add){
            hs.add(nums[index]);
            return true;
        }

        return backtrack(nums, index + 1, target, hs, curr);
    }
    public boolean checkEqualPartitions(int[] nums, long target) {
        HashSet<Integer> hs = new HashSet<>();

        boolean ans = backtrack(nums, 0, target, hs, 1);
        if(!ans) return false;

        long product = 1;
        for(int num : nums){
            if(!hs.contains(num)) product *= num;
        }

        return product == target;
    }
}