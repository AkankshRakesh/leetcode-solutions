class Solution {
    public int gcd(int a, int b){
        int res = a % b;
        if(res == 0) return b;
        return gcd(b, res);
    }
    public int gcdOfOddEvenSums(int n) {
        int odd = 0, even = 0;
        for(int i = 1; i <= n * 2; i++){
            if(i % 2 == 0) even += i;
            else odd += i;
        }

        return gcd(even, odd);
    }
}