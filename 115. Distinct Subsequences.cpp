class Solution {
    struct Pair {
        int first, second;
        Pair(int f, int s) : first(f), second(s) {}

        bool operator==(const Pair& other) const {
            return first == other.first && second == other.second;
        }
    };

    struct PairHash {
        size_t operator()(const Pair& p) const {
            return 31 * p.first + p.second;
        }
    };

public:
    int count(const string& s, const string& t,
              unordered_map<Pair, int, PairHash>& memo,
              int i, int j, int n, int m) {
        if (j == m) return 1;
        if (i == n) return 0;

        Pair p(i, j);
        if (memo.find(p) != memo.end()) return memo[p];

        int c = 0;
        if (s[i] == t[j]) {
            c = count(s, t, memo, i + 1, j + 1, n, m) +
                count(s, t, memo, i + 1, j, n, m);
        } else {
            c = count(s, t, memo, i + 1, j, n, m);
        }

        memo[p] = c;
        return c;
    }

    int numDistinct(string s, string t) {
        unordered_map<Pair, int, PairHash> memo;
        return count(s, t, memo, 0, 0, s.length(), t.length());
    }
};