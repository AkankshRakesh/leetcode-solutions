class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] suffix = new int[n];
        int max = nums[0], min = nums[n - 1];

        for(int i = n - 1; i >= 0; i--){
            min = Math.min(min, nums[i]);
            suffix[i] = min;
        }

        for(int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
            if(max - suffix[i] <= k) return i;
        }

        return -1;
    }
}