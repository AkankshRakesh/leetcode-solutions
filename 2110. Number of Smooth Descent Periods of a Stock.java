class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = prices.length;
        // HashMap<Long, Long> sumHm = new HashMap<>();
        int left = 0, right = 1;
        while(right < prices.length){
            if(prices[right] + 1 != prices[right - 1]){
                int num = right - left - 1;
                // if(sumHm.contains(num))
                long sum = 0;
                while(num > 0){
                    sum += num;
                    num--;
                }

                ans += sum;
                left = right;
            }
            right++;
        }
        int num = right - left - 1;
        // if(sumHm.contains(num))
        long sum = 0;
        while(num > 0){
            sum += num;
            num--;
        }

        ans += sum;

        return ans;
    }
}