class Solution {
public:
    bool canDefeat(long long strength, vector<int>& monsters, vector<long long>& diff) {
        long long bonus = 0;

        for (int i = 0; i < monsters.size(); i++) {
            bonus += diff[i];

            if (strength + bonus < monsters[i])
                return false;

            strength = max(strength - monsters[i], 0LL);
        }

        return true;
    }

    long long minInitialStrength(vector<int>& monsters, vector<vector<int>>& boosts) {
        long long ans = INT_MAX;

        vector<long long> diff(monsters.size() + 1, 0);
        for (vector<int>& boost : boosts) {
            diff[boost[0]] += boost[2];
            diff[boost[1] + 1] -= boost[2];
        }

        long long left = 0, right = 0;
        for (int monster : monsters)
            right += monster;

        while (left <= right) {
            long long mid = left + (right - left) / 2;

            if (canDefeat(mid, monsters, diff)) {
                ans = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }

        return ans;
    }
};