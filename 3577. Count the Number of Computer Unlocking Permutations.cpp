class Solution {
public:
    int MOD = 1'000'000'007;

    int countPermutations(vector<int>& complexity) {
        long long ans = 1;
        int first = complexity[0];
        bool passedFirst = false;

        for (int comp : complexity) {
            if ((comp == first || comp < first) && passedFirst) return 0;
            passedFirst = true;
        }

        for (int i = 2; i < (int)complexity.size(); i++) {
            ans = (ans * i) % MOD;
        }

        return (int)ans;
    }
};
