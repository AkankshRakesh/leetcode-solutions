class Solution {
public:
    static const int MOD = 1'000'000'007;

    int specialTriplets(vector<int>& nums) {
        long long ans = 0;
        unordered_map<int,int> freqNext, freqPrev;

        for (int num : nums)
            freqNext[num]++;

        for (int num : nums) {

            if (freqNext[num] == 1) freqNext.erase(num);
            else freqNext[num]--;

            int target = num * 2;

            if (freqPrev.count(target) && freqNext.count(target)) {
                ans = (ans + (long long) freqPrev[target] * freqNext[target]) % MOD;
            }

            freqPrev[num]++;
        }

        return (int)ans;
    }
};
