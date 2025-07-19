class Solution {
    public boolean isPrime(int n){
        if(n <= 1) return false;

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }

        return true;
    }
    public long splitArray(int[] nums) {
        int n = nums.length;

        long a = 0, b = 0;
        for(int i = 0; i < n; i++){
            if(isPrime(i)) b += nums[i];
            else a += nums[i];
        }

        return Math.abs(a - b);
    }
}