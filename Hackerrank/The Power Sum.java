class Result {

    /*
     * Complete the 'powerSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER X
     *  2. INTEGER N
     */
    public static long fastPow(long n, long pow){
        if(pow == 0) return 1;
        if(pow == 1) return n;
        if(pow % 2 != 0) return n * fastPow(n, pow - 1);
        
        long res = fastPow(n, pow / 2);
        return res * res;
    }
    public static int backtrack(int X, int pow, int num, long curr){
        if(curr > X) return 0;
        if(curr == X) return 1;
        
        long nextAdd = fastPow(num, pow);
        if(nextAdd > X) return 0;
        return backtrack(X, pow, num + 1, nextAdd + curr) + backtrack(X, pow, num + 1, curr);
    }
    public static int powerSum(int X, int N) {
        return backtrack(X, N, 1, 0);
    }

}