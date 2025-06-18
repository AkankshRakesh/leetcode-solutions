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
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        nums = countSort(nums);
        // for(int num: nums) System.out.print(num);

        int[][] ans = new int[n / 3][3];
        boolean ansFound = true;

        for(int i = 0; i < n; i += 3){
            if(nums[i + 2] - nums[i] <= k && nums[i + 2] - nums[i + 1] <= k){
                ans[i / 3][0] = nums[i];
                ans[i / 3][1] = nums[i + 1];
                ans[i / 3][2] = nums[i + 2];
            }
            else{
                ansFound = false;
                break;
            }
        }

        if(!ansFound) return new int[0][0];
        return ans;
    }
}