class Solution {
    public int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public int minOperations(int[] nums) {
        int n = nums.length;
        int minLenDiff = Integer.MAX_VALUE;
        int ones = 0;
        for(int i = 0; i < n; i++){
            int g = nums[i];
            if(g == 1) ones++;
            for(int j = i+1; j < n; j++){
                g = gcd(g, nums[j]);
                if(g == 1){
                    minLenDiff = Math.min(minLenDiff, j - i);
                    break;
                }
            }
        }

        return minLenDiff == Integer.MAX_VALUE ? -1 : minLenDiff + (n - 1) - ones;
    }
}