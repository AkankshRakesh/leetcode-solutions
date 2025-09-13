class Solution {
    static long MOD = (long)1e9 + 7;
    public long fastPow(long n, long pow){
        if(pow == 0) return 1;
        else if(pow % 2 == 0){
            long res = fastPow(n, pow / 2) % MOD;
            return (res * res) % MOD;
        }
        else{
            return (n * (fastPow(n, pow - 1))) % MOD;
        }
    }
    public int countGoodNumbers(long n) {
        long even = (n + 1)/2;
        long odd = n / 2;
        
        long part1 = fastPow(5, even) % MOD;
        long part2 = fastPow(4, odd) % MOD;

        return (int)((part1 * part2) % MOD);
    }
}