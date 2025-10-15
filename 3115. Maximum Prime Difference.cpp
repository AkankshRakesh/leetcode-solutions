class Solution {
    public boolean isPrime(int n){
        if(n <= 1) return false;
        if(n == 2 || n == 3) return true;
        if(n % 2 == 0 || n % 3 == 0) return false;

        for(int i = 5; i * i <= n; i += 6){
            if(n % i == 0 || n % (i + 2) == 0) return false;
        }

        return true;
    }
    public int maximumPrimeDifference(int[] nums) {
        int first = -1, last = -1;
        for(int i = 0; i < nums.length; i++){
            if(isPrime(nums[i])){
                if(first == -1) first = i;
                last = i;
            }
        }

        System.out.println(first);
        return last - first;
    }
}