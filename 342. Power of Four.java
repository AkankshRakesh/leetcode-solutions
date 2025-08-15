class Solution {
    public boolean check(int n){
        int mask = 0b01010101010101010101010101010101;
        if((mask | n) == mask) return true;

        return false;
    }
    public boolean isPowerOfFour(int n) {
        if(n > 0 && ((n & (n - 1)) == 0) && check(n)) return true;

        return false;
    }
}