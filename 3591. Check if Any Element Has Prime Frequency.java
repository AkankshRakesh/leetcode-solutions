class Solution {
    public boolean isPrime(int ele){
        if(ele <= 1) return false;
        for(int i = 2; i < ele; i++){
            if(ele % i == 0) return false;
        }

        return true;
    }
    public boolean checkPrimeFrequency(int[] nums) {
        int[] arr = new int[101];
        int n = nums.length;
        for(int num : nums) arr[num]++;
        for(int i = 0; i <= 100; i++){
            if(isPrime(arr[i])) return true;
        }

        return false;
    }
}