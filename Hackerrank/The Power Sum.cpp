class Result {
public:

    static long long fastPow(long long n, long long pow) {
        if (pow == 0) return 1;
        if (pow == 1) return n;
        if (pow % 2 != 0) return n * fastPow(n, pow - 1);

        long long res = fastPow(n, pow / 2);
        return res * res;
    }

    static int backtrack(int X, int pow, int num, long long curr) {
        if (curr > X) return 0;
        if (curr == X) return 1;

        long long nextAdd = fastPow(num, pow);
        if (nextAdd > X) return 0;

        return backtrack(X, pow, num + 1, nextAdd + curr)
             + backtrack(X, pow, num + 1, curr);
    }

    static int powerSum(int X, int N) {
        return backtrack(X, N, 1, 0);
    }
};
