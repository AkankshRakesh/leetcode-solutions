class Solution {
    public int gcd(int a, int b){
        int res = a % b;
        if(res == 0) return b;
        return gcd(b, res);
    }
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];

        int max = nums[0];
        for(int i = 0; i < n; i++){
            max = Math.max(nums[i], max);
            prefixGcd[i] = gcd(nums[i], max);
        }

        Arrays.sort(prefixGcd);

        long ans = 0;
        for(int i = 0; i < n / 2; i++){
            // System.out.println(prefixGcd[i] + " " + prefixGcd[n - 1 - i]);
            ans += gcd(prefixGcd[i], prefixGcd[n - 1 - i]);
        }

        return ans;
    }
}