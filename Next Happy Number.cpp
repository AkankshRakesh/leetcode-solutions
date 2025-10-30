class Solution {
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