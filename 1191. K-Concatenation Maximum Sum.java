class Solution {
    int MOD = 1_000_000_007;
    public long kadane(int[] arr){
        long currSum = 0, globalSum = 0;
        for(int num : arr){
            currSum = Math.max(num, num + currSum);
            globalSum = Math.max(currSum, globalSum);
        }

        return globalSum % MOD;
    }
    public int kConcatenationMaxSum(int[] arr, int k) {
        if(k == 1) return (int)kadane(arr);

        int[] nums = new int[arr.length * 2];
        for(int i = 0; i < arr.length; i++){
            nums[i] = arr[i];
            nums[i + arr.length] = arr[i];
        }

        long maxSum = kadane(nums);
        long arrSum = 0;
        for(int num : arr) arrSum += num;

        if(arrSum <= 0) return (int)maxSum % MOD;
        return (int)((maxSum + (k - 2) * arrSum) % MOD);
    }
}