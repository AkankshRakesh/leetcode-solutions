class Solution {
    public int[] minCosts(int[] cost) {
        int n = cost.length;
        int[] answer = new int[n];
        int minSoFar = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (cost[i] < minSoFar) {
                minSoFar = cost[i];
            }
            answer[i] = minSoFar;
        }
        return answer;
    }
}