class Solution {

    private static final int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {
        long[][][] dp = new long[n][n][2];


        for (int src = 0; src < n; src++) {
            for (int dest = 0; dest < n; dest++) {
                if (src != dest) {
                    dp[src][dest][0] = (long) 1e12;
                    dp[src][dest][1] = 0;
                } else {
                    dp[src][dest][0] = 0;
                    dp[src][dest][1] = 1;
                }
            }
        }

        for (int[] road : roads) {
            int startNode = road[0], endNode = road[1], travelTime = road[2];
            dp[startNode][endNode][0] = travelTime;
            dp[endNode][startNode][0] = travelTime;
            dp[startNode][endNode][1] = 1;
            dp[endNode][startNode][1] = 1;
        }

        for (int mid = 0; mid < n; mid++) {
            for (int src = 0; src < n; src++) {
                for (int dest = 0; dest < n; dest++) {
                    if (src != mid && dest != mid) {
                        long newTime = dp[src][mid][0] + dp[mid][dest][0];

                        if (newTime < dp[src][dest][0]) {
                            dp[src][dest][0] = newTime;
                            dp[src][dest][1] =
                                (dp[src][mid][1] * dp[mid][dest][1]) % MOD;
                        } else if (newTime == dp[src][dest][0]) {
                            dp[src][dest][1] =
                                (dp[src][dest][1] +
                                    dp[src][mid][1] * dp[mid][dest][1]) %
                                MOD;
                        }
                    }
                }
            }
        }

        return (int) dp[n - 1][0][1];
    }
}