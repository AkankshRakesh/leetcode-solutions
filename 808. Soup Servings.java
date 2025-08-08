class Solution {
    Map<String, Double> memo = new HashMap<>();

    public double p(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;

        String key = a + "," + b;
        if (memo.containsKey(key)) return memo.get(key);

        double res = 0.25 * (
            p(a - 100, b) +
            p(a - 75, b - 25) +
            p(a - 50, b - 50) +
            p(a - 25, b - 75)
        );

        memo.put(key, res);
        return res;
    }

    public double soupServings(int n) {
        if (n >= 5000) return 1.0; 
        return p(n, n);
    }
}
