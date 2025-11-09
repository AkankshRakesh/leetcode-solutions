class Solution {
public:
    bool backtrack(long a, long b, long c, long d, const std::vector<int>& matchsticks, int index, long target, std::unordered_map<std::string, bool>& hm) {
        if (index >= (int)matchsticks.size()) {
            return (a == b && b == c && c == d);
        }
        std::string key = std::to_string(a) + "-" + std::to_string(b) + "-" + std::to_string(c) + "-" + std::to_string(d) + "-" + std::to_string(index);
        if (hm.find(key) != hm.end()) return hm[key];

        int curr = matchsticks[index];
        bool res = false;
        for (int i = 0; i < 4; i++) {
            if (i == 0 && curr + a <= target) res |= backtrack(a + curr, b, c, d, matchsticks, index + 1, target, hm);
            else if (i == 1 && curr + b <= target) res |= backtrack(a, b + curr, c, d, matchsticks, index + 1, target, hm);
            else if (i == 2 && curr + c <= target) res |= backtrack(a, b, c + curr, d, matchsticks, index + 1, target, hm);
            else if (i == 3 && curr + d <= target) res |= backtrack(a, b, c, d + curr, matchsticks, index + 1, target, hm);
        }

        hm[key] = res;
        return res;
    }

    bool makesquare(std::vector<int>& ms) {
        std::sort(ms.begin(), ms.end());
        int n = (int)ms.size();
        for (int i = 0; i < n / 2; i++) {
            std::swap(ms[i], ms[n - i - 1]);
        }
        long target = 0;
        for (int stick : ms) target += stick;

        if (target % 4 != 0) return false;
        std::unordered_map<std::string, bool> hm;
        return backtrack(0, 0, 0, 0, ms, 0, target / 4, hm);
    }
};