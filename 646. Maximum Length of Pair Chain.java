class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        int last = pairs[0][1];
        int n = pairs.length;
        int ans = 1;

        for(int i = 0; i < n; i++){
            if(last < pairs[i][0]){
                last = pairs[i][1];
                ans++;
            }
        }

        return ans;
    }
}