class Solution {
    public double gcd(double a, double b){
        if(b == 0) return a;
        if(a < b) return gcd(b, a);

        return gcd(b, a % b);
    }
    public double lcm(double a, double b) {
        if (a == 0 || b == 0) {
            return 0;
        }

        return Math.abs(a / gcd(a, b)) * Math.abs(b);
    }
    public int maxLength(int[] nums) {
        int ans = 1;
        for(int i = 0; i < nums.length; i++){
            double lastGcd = nums[i];
            double lastLcm = nums[i];
            double prod = nums[i];
            for(int j = i + 1; j < nums.length; j++){
                prod *= nums[j];
                lastGcd = gcd(lastGcd, nums[j]);
                lastLcm = lcm(lastLcm, nums[j]);

                // System.out.println(lastLcm + " " + lastGcd + " " + prod);
                if(lastLcm * lastGcd == prod) ans = Math.max(ans, j - i + 1);
            }
        }

        return ans;
    }
}