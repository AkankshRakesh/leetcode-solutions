class Solution {
    public List<Integer> maxPrimes(int n, int s) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for(int i = 2; i <= n; i++){
            if(isPrime[i]){
                for(int j = i + i; j <= n; j += i) isPrime[j] = false;
            }
        }

        List<Integer> ans = new ArrayList<>();
        int sum = 0;
        for(int i = 2; i <= n; i++){
            if(isPrime[i]){
                sum += i;
                if(sum > s) break;
                ans.add(i);
            }
        }

        return ans;
    }
}