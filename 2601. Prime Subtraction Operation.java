class Solution {
    public boolean primeSubOperation(int[] nums) {
        int max = 0;
        for (int n : nums) max = Math.max(max, n);

        boolean[] isPrime = new boolean[max + 1];
        for (int i = 2; i <= max; i++) isPrime[i] = true;
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int prev = -1;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            boolean found = false;
            for(int j = num - 1; j >= 2; j--){
                if(isPrime[j]){
                    if(num - j > prev){
                        nums[i] = num - j;
                        found = true;
                        break;
                    }
                }
            }

            if(!found && nums[i] <= prev) return false;
            System.out.println(nums[i]);
            prev = nums[i];
        }

        return true;
    }
}