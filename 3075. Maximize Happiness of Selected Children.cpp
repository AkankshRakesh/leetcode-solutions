class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long ans = 0;
        int time = 0;
        for(int i = happiness.length - 1; i >= happiness.length - k; i--){
            ans += Math.max(0, (happiness[i] - time));
            System.out.println(ans);
            time++;
        }

        return ans;
    }
}