class Solution {
    public boolean isPrime(int num){
        if(num <= 1) return false;
        if(num == 2 || num == 3) return true;
        if(num % 2 == 0 || num % 3 == 0) return false;

        for(int i = 5; i * i <= num; i++){
            if(num % i == 0) return false;
        }

        return true;
    }
    public boolean completePrime(int num) {
        String str = Integer.toString(num);
        if(!isPrime(num)) return false;
    
        int n1 = 0;
        StringBuilder sb = new StringBuilder(str);
        for(int i = 0; i < str.length() - 1; i++){
            n1 *= 10;
            n1 += str.charAt(i) - '0';
            sb.deleteCharAt(0);
            // System.out.print(n1 + " ");
            if(!isPrime(n1) || !isPrime(Integer.parseInt(sb.toString()))) return false;
        }

        return true;
    }
}