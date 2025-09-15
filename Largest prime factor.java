// User function Template for Java

class Solution {
    static int largestPrimeFactor(int n) {
        int max = Integer.MIN_VALUE;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                max = Math.max(max, i);
                while(n % i == 0) n /= i;
            }
        }
        
        if(n > 2) max = Math.max(max, n);
        
        return max;
    }
}