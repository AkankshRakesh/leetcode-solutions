class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long original = 0;
        for (int i = 0; i < n; i++)
            original += (long) prices[i] * strategy[i];

        long[] buyToHold = new long[n + 1];
        long[] holdToSell = new long[n + 1];

        for (int i = 0; i < n; i++) {
            buyToHold[i + 1] = buyToHold[i] - (long) strategy[i] * prices[i];
            holdToSell[i + 1] = holdToSell[i] + ((long) 1 - strategy[i]) * prices[i];
        }

        long maxGain = 0;

        for (int start = 0; start <= n - k; start++) {
            int mid = start + k / 2;
            int end = start + k;

            long gain = (buyToHold[mid] - buyToHold[start]) + (holdToSell[end] - holdToSell[mid]);
            if (gain > maxGain)
                maxGain = gain;
        }

        return original + maxGain;
    }
}   