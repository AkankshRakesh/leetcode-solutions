class Solution {
    public int reverse(int x) {
        int ans = 0;
        boolean isNeg = false;
        if(x < 0){
            isNeg = true;
            if(x == Integer.MIN_VALUE) return 0;
            x = -x; 
        }
        
        while(x != 0){
            int digit = x % 10;
            x /= 10;
            if(ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) return 0;
            ans *= 10;
            ans += digit;
        }

        return isNeg ? -ans : ans;
    }
}