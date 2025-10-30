class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        long ans = 0;
        for(int i = 0; i < nums.length; i++){
            nums[i] = nums[i] - target[i];
        }

        int prev = 0;
        for(int num : nums){
            if(num < 0){
                if(prev < 0 && prev > num) ans += prev - num;
                else if(prev >= 0) ans -= num;
            }
            else{
                if(prev > 0 && prev < num) ans += num - prev;
                else if(prev <= 0) ans += num;
            }
            prev = num;
        }

        return ans;
    }
}