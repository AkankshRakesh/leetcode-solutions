class Solution {
    public int[] sumZero(int n) {
        if(n == 1) return new int[]{0};
        int num = n;
        int[] ans = new int[n];
        int len = 0;

        for(int i = 0; i < n / 2; i++){
            ans[len++] = -num;
            ans[len++] = num;
            num--;
        }
        if(n % 2 != 0) ans[len] = 0;

        return ans;
    }
}