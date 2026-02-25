class Solution {
    public int countOnes(int n){
        int count = 0;
        while(n != 0){
            count += (n & 1);
            n = n >> 1;
        }
        return count;
    }
    public int[] sortByBits(int[] arr) {
        int[][] nums = new int[arr.length][2];
        for(int i = 0; i < arr.length; i++){
            nums[i][0] = countOnes(arr[i]);
            nums[i][1] = arr[i];
        }
        Arrays.sort(nums, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        
        int[] ans = new int[arr.length];
        for(int i = 0; i < arr.length; i++) ans[i] = nums[i][1];
        return ans;
    }
}