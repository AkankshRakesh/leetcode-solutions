class Solution {
    public int climbStairs(int n) {
        int a = 0;
        int b = 1;
        while(n != 0){
            int temp = a;
            a = b;
            b += temp;
            n--;
        }

        return b;
    }
}