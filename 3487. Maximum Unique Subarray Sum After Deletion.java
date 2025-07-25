class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int n = nums.length;

        int sum = 0;
        for(int num: nums){
            if(!hs.contains(num) && num > 0){
                hs.add(num);
                sum += num;
            }
        }
        if(sum == 0){
            sum = nums[0];
            for(int num: nums){
                if(sum < num) sum = num;
            }
        }
        return sum;
    }
}