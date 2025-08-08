class Solution {
public:
    unordered_map<string, double> memo;

    double p(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;

        string key = to_string(a) + "," + to_string(b);
        if (memo.count(key)) return memo[key];

        double res = 0.25 * (
            p(a - 100, b) +
            p(a - 75, b - 25) +
            p(a - 50, b - 50) +
            p(a - 25, b - 75)
        );

        return memo[key] = res;
    }

    double soupServings(int n) {
        if (n >= 5000) return 1.0;
        return p(n, n);
    }
};
