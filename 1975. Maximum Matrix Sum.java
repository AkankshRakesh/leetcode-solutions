class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long ans = 0;
        int minPoss = Integer.MAX_VALUE;
        int negC = 0;

        for (int[] row : matrix) {
            for (int val : row) {
                ans += Math.abs(val);
                if (val < 0) negC++;
                minPoss = Math.min(minPoss, Math.abs(val));
            }
        }
        if (negC % 2 != 0) ans -= 2 * minPoss;

        return ans;
    }
}