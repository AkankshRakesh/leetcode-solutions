class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int curr = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            curr *= nums[i];
            ans[i] = curr;
        }
        
        curr = 1;
        for(int i = 0; i < nums.length; i++){
            int suffix = i + 1 < nums.length ? ans[i + 1] : 1;
            curr = i - 1 >= 0 ? curr * nums[i - 1] : curr;
            ans[i] = curr * suffix;
        }
        return ans;
    }
}