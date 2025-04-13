class Solution {
    long mod = 1000000007;
    public int countGoodNumbers(long n) {
        return (int) ((expo(5, (n + 1)/2) * expo(4, n/2)) % mod);
    }
    public long expo(int x, long y){
        long res = 1;
        long mul = x;
        while(y > 0){
            if(y % 2 == 1){
                res = (res * mul) % mod;
            }
            mul = (mul * mul) % mod;
            y/=2;
        }
        return res;
    }
}