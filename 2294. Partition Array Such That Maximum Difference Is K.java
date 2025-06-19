class Solution {
    public static int[] countSort(int[] inputArray) {
        int N = inputArray.length;
        int M = 0;

        for (int i = 0; i < N; i++) {
            M = Math.max(M, inputArray[i]);
        }

        int[] countArray = new int[M + 1];

        for (int i = 0; i < N; i++) {
            countArray[inputArray[i]]++;
        }

        for (int i = 1; i <= M; i++) {
            countArray[i] += countArray[i - 1];
        }

        int[] outputArray = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            outputArray[countArray[inputArray[i]] - 1] = inputArray[i];
            countArray[inputArray[i]]--;
        }

        return outputArray;
    }
    public int partitionArray(int[] nums, int k) {
        int n = nums.length;
        nums = countSort(nums);

        int ans = 1, currMin = nums[0];
        for(int i = 1; i < n; i++){
            if(nums[i] - currMin > k){
                ans++;
                currMin = nums[i];
            }
        }

        return ans;
    }
}