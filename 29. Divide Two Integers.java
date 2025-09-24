class Solution {
    int max = Integer.MAX_VALUE;
    int min = Integer.MIN_VALUE;
    public int divide(int dividend, int divisor) {
        if (dividend == min) {
            if (divisor == 1) return min;
            if (divisor == -1) return max;
        }
        
        if (divisor == min) {
            return dividend == min ? 1 : 0;
        }
        
        if (dividend != min && Math.abs(dividend) < Math.abs(divisor)) return 0;
        
        boolean neg = (dividend < 0) ^ (divisor < 0);
        
        int a;
        int extra = 0;
        if (dividend == min) {
            dividend += Math.abs(divisor);
            extra = 1;
        }
        a = Math.abs(dividend);
        int b = Math.abs(divisor);
        
        int ans = 0;
        while (a >= b) {
            int div = b;
            int q = 1;
            while (div <= (Integer.MAX_VALUE >> 1) && a >= (div << 1)) {
                div <<= 1;
                q <<= 1;
            }
            a -= div;
            ans += q;
        }
        
        if (extra == 1) ans += 1;
        
        return neg ? -ans : ans;
    }
}