class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 == 0) return nums.length - 1;
        else return 0;
    }
}