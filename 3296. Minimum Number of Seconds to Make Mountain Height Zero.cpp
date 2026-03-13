class Solution {
    public boolean check(int[] workerTimes, long target, int totalJob){
        long jobDone = 0;
        for(int worker : workerTimes){
            jobDone += (long)((Math.sqrt(1 + (8.0 * target) / worker) - 1) / 2);
        }

        if(jobDone >= totalJob) return true;
        return false;
    }
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long ans = 0;
        Arrays.sort(workerTimes);
        long left = 0, right = 0;
        right = (long)((mountainHeight / 2.0) * (2 + mountainHeight - 1));
        right *= workerTimes[0];

        while(left <= right){
            long mid = left + (right - left) / 2;
            if(check(workerTimes, mid, mountainHeight)){
                ans = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }

        return ans;
    }
}