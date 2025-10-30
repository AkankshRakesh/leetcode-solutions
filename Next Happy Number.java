// User function Template for Java

class Solution {
    // static int fastPow(int n, int pow){
    //     if(pow == 1) return n;
    //     if(pow % 2 != 0) return n * fastPow(n, pow - 1);
        
    //     int num = fastPow(n, pow / 2);
    //     return num * num;
    // }
    static boolean operations(int n){
        if(n == 1 || n == 7) return true;
        if(n < 10) return false;
        int sum = 0;
        while(n != 0){
            int last = n % 10;
            sum += (last * last);
            n /= 10;
        }
        
        return operations(sum);
    }
    static int nextHappy(int N) {
        int num = N + 1;
        while(true){
            if(operations(num)) return num;
            num++;
        }
    }
}