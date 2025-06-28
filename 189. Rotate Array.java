class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k == n) return;
        if(n == 1) return;
        k %= n;
        int[] lastEle = new int[k];
        for(int i = n - k; i < n; i++) lastEle[i - (n - k)] = nums[i];

        int right = n - 1;
        for(int i = n - k - 1; i >= 0; i--){
            nums[right--] = nums[i];
        }
        for(int i = 0; i < k; i++){
            nums[i] = lastEle[i];
        }
    }
}