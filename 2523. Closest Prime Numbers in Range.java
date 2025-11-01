class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        for(int i = 2; i <= right; i++) isPrime[i] = true;

        for(int i = 2; i * i <= right; i++){
            if(isPrime[i]){
                for(int j = i + i; j <= right; j += i) isPrime[j] = false;
            }
        }

        int lastPrime = -1;
        int ans = Integer.MAX_VALUE;
        int leastDiff[] = new int[2];
        leastDiff[0] = -1;
        leastDiff[1] = -1;

        for(int i = left; i <= right; i++){
            if(isPrime[i]){
                if(lastPrime == -1) lastPrime = i;
                else{
                    if(ans > i - lastPrime){
                        ans = i - lastPrime;
                        leastDiff[0] = lastPrime;
                        leastDiff[1] = i;
                    }
                    lastPrime = i;
                }
            }
        }

        return leastDiff;
    }
}