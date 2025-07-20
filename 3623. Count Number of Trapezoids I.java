class Solution {
    static final int MOD = 1_000_000_007;
    public long modInv(long n, int mod){
        return pow(n, mod - 2, mod);
    }
    public long pow(long initial, long exp, int mod){
        long result = 1;
        initial %= mod;

        while(exp > 0){
            if((exp & 1) == 1) result = (result * initial) % mod;
            initial = (initial * initial) % mod;
            exp >>= 1;
        }

        return result;
    }
    public int countTrapezoids(int[][] points) {

        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for(int[] point: points){
            int x = point[0];
            int y = point[1];
            if(!hm.containsKey(y)){
                hm.put(y, new ArrayList<>());
            }
            hm.get(y).add(x);
        }

        long total = 0;
        long sumPoints = 0;
        
        for(ArrayList<Integer> tempArr : hm.values()){
            int n = tempArr.size();

            if(n >= 2){
                long combinations = ((long)n * (n - 1)) / 2;
                total = (total + combinations) % MOD;
                sumPoints = (sumPoints + (combinations * combinations) % MOD) % MOD;
            }
        }

        long result = ((total * total) % MOD - sumPoints + MOD) % MOD;
        result = result * modInv(2, MOD) % MOD;
        // System.out.println(modInv(2, MOD));
        return (int)result;
    }
}