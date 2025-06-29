class Solution {
    int mod = mod = (int)1e9 + 7;
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        int[] powList = new int[n];
        powList[0] = 1;
        for(int i = 1; i < n; i++){
            powList[i] = (powList[i - 1] * 2) % mod;
        }

        Arrays.sort(nums);

        int left = 0, right = n - 1;
        int ans = 0;
        while(left <= right){
            int currSum = nums[left] + nums[right];
            if(currSum > target) right--;
            else{
                ans = (ans + powList[right - left]) % mod;
                left++;
            }
        }

        return ans;
    }
}