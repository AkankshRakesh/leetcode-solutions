class Solution {
    public boolean isPrime(int n){
        if(n == 1) return false;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    public int primePalindrome(int n) {
        if(n < 12){
            while(true){
                if(isPrime(n)) return n;
                n++;
            }
        }
        else{
            for(int i = 1; i < 100000; i++){
                String s = Integer.toString(i);
                String rev = new StringBuilder(s).reverse().toString();
                Integer ele = Integer.parseInt(s + rev.substring(1));
                if(ele >= n && isPrime(ele)) return ele;
            }
        }
        return 0;
    }
}