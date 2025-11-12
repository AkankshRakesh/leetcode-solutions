class Solution {
    public double fastPow(double x, long n){
        if(n == 0) return 1;
        if(n % 2 != 0) return x * fastPow(x, n - 1);
        else{
            double res = fastPow(x, n / 2);
            return res * res;
        }
    }
    public double myPow(double x, int n) {
        boolean neg = false;
        double ans = 0;
        long num = n;
        if(num < 0){
            neg = true;
            ans = fastPow(x, -num);
        }
        else{
            ans = fastPow(x, num);
        }

        return neg ? 1.0 / ans : ans;
    }
}