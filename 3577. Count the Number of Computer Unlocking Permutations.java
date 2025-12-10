class Solution {
    public int MOD = 1_000_000_007;
    public int countPermutations(int[] complexity) {
        long ans = 1;
        int first = complexity[0];
        boolean passedFirst = false;
        for(int comp : complexity){
            if((comp == first || comp < first) && passedFirst) return 0;
            passedFirst = true;
        }

        for(int i = 2; i < complexity.length; i++){
            ans = (ans * i) % MOD;
        }
        return (int)ans;
    }
}