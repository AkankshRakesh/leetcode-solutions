class Solution {
public:
    bool check(const vector<int>& workerTimes, long long target, int totalJob) {
        long long jobDone = 0;
        for (int worker : workerTimes) {
            jobDone += static_cast<long long>((sqrt(1 + (8.0 * target) / worker) - 1) / 2);
        }
        return jobDone >= totalJob;
    }

    long long minNumberOfSeconds(int mountainHeight, vector<int>& workerTimes) {
        long long ans = 0;
        sort(workerTimes.begin(), workerTimes.end());
        long long left = 0, right = 0;
        right = static_cast<long long>((mountainHeight / 2.0) * (2 + mountainHeight - 1));
        right *= workerTimes[0];

        while (left <= right) {
            long long mid = left + (right - left) / 2;
            if (check(workerTimes, mid, mountainHeight)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
};