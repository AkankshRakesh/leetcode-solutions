class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long n = nums.length;
        long left = 0;
        long ans = 0;
        for(long right = 1; right < n; right++){
            while(nums[(int)left] != 0 && left < right) left++;
            if(nums[(int)right] != 0 && right - left > 0){
                long ele = right - left;
                ans += (right - left);
                ans += (((ele)*(ele - 1))/2);
                left = right;
            }
        }
        if(nums[(int)n - 1] == 0 && n - left > 0){
            long ele = n - left;
            ans += (n - left);
            ans += (((ele)*(ele - 1))/2);
        }
        return ans;
    }
}