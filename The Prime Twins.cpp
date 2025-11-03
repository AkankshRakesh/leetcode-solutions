// User function Template for Cpp
class Solution {
    public int[] primeTwins(int L, int R) {
        boolean[] isPrime = new boolean[R + 1];
        for(int i = 2; i <= R; i++) isPrime[i] = true;
        
        for(int i = 2; i <= R; i++){
            if(isPrime[i]){
                for(int j = i + i; j <= R; j += i) isPrime[j] = false;
            }
        }
        
        int lastPrime = -1;
        
        for(int i = L; i <= R; i++){
            if(isPrime[i]){
                if(lastPrime == -1) lastPrime = i;
                else{
                    if(i - lastPrime == 2) return new int[]{lastPrime, i};
                    else lastPrime = i;
                }
            }    
        }
        
        return new int[]{-1};
    }
}