// User function Template for Cpp

class Solution {
    public boolean isPrime(int n){
        if(n <= 1) return false;
        for(int i = 2; i * i <= n; i++) if(n % i == 0) return false;
        
        return true;
    }
    int isTwistedPrime(int N) {
        if(!isPrime(N)) return 0;
        StringBuilder sb = new StringBuilder(Integer.toString(N));
        sb.reverse();
        Integer revN = Integer.parseInt(sb.toString());
        if(!isPrime(revN)) return 0;
        
        return 1;
    }
}