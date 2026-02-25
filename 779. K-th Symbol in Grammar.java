class Solution {
    public int solve(int n, int k, boolean flip){
        if(n == 1){
            if(flip) return 1;
            return 0;
        }
        int curr = (int)Math.pow(2, n - 1);
        if(curr / 2 < k) return solve(n - 1, k - (curr / 2), !flip);
        return solve(n - 1, k, flip);
    }
    public int kthGrammar(int n, int k) {
        return solve(n, k, false);
    }
}