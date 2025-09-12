class Solution {
public:
    double exp(double x, int n, unordered_map<string, double>& hm) {
        if (n == 0) return 1.0;
        if (n == 1) return x;

        ostringstream oss;
        oss << fixed << setprecision(3) << x << "-" << n;
        string key = oss.str();

        if (hm.find(key) != hm.end()) return hm[key];

        double half = exp(x, n / 2, hm);
        double res;
        if (n % 2 == 0) res = half * half;
        else res = half * half * x;

        hm[key] = res;
        return res;
    }

    double myPow(double x, int n) {
        unordered_map<string, double> hm;

        long long N = n; 
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        if (N % 2 == 0) return exp(x, (int)N, hm);
        return x * exp(x, (int)N - 1, hm);
    }
};
