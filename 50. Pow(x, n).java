class Solution {
    public double exp(double x, int n, HashMap<String, Double> hm){
        if(n == 0) return 1;
        if(n == 1) return x;

        String key = String.format("%.3f", x) + "-" + n;
        if(hm.containsKey(key)) return hm.get(key);
        
        double half = exp(x, n / 2, hm);
        double res;
        if(n % 2 == 0) res = half * half;
        else res = half * half * x;
        hm.put(key, res);
        return res;
    }
    public double myPow(double x, int n) {
        HashMap<String, Double> hm = new HashMap<>();
        
        if(n < 0){
            x = 1 / x;
            n = -n;
        }
        if(n % 2 == 0) return exp(x, n, hm);
        return x * exp(x, n - 1, hm);
    }
}