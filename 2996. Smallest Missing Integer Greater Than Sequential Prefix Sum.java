class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        for(int i = 1; i < nums.length && nums[i] == nums[i - 1] + 1; i++){
            sum += nums[i];
        }

        HashSet<Integer> hs = new HashSet<>();
        for(int j = 0; j < nums.length; j++){
            hs.add(nums[j]);
        }

        while(hs.contains(sum)) sum++;
        return sum;
    }
}