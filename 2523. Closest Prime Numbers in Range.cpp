class Solution {
    public int[] closestPrimes(int leftRange, int rightRange) {
        int n = rightRange - leftRange + 1;
        int rootn = (int)Math.sqrt(rightRange);
        boolean[] sieve = new boolean[rightRange + 1];

        for(int i = 2; i * i <= rightRange; i++){
            if(!sieve[i]){
                for(int j = i + i; j <= rightRange; j += i) sieve[j] = true;
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();
        for(int i = leftRange; i <= rightRange; i++){
            if(!sieve[i]) primes.add(i);
        }

        // if(primes.size() == 0) return new int[]{-1, -1};
        int ans = Integer.MAX_VALUE;
        int[] ansArr = new int[2];
        for(int i = 1; i < primes.size(); i++){
            if(primes.get(i) == 2) continue; 
            if(primes.get(i) - primes.get(i - 1) < ans){
                ans = primes.get(i) - primes.get(i - 1);
                ansArr[0] = primes.get(i - 1);
                ansArr[1] = primes.get(i);
            } 
        } 

        if(ans == Integer.MAX_VALUE) return new int[]{-1, -1};
        return ansArr;
    }
}