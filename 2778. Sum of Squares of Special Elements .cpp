class Solution {
    public int sumOfSquares(int[] nums) {
        int ans = 0;
        int index = 1;
        for(int num : nums){
            if(nums.length % index == 0) ans += (num * num);
            index++;
        }

        return ans;
    }
}