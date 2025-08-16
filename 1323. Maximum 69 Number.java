class Solution {
    public int maximum69Number (int num) {
        boolean changed = false;
        int ans = 0;
        int digits = 0;
        int temp = num;
        while(temp != 0){
            digits++;
            temp /= 10;
        }
        digits--;
        while(digits != 0){
            int curr = num / (int)(Math.pow(10, digits));
            if(curr % 10 == 6 && !changed){
                changed = true;
                ans += 9;
            }
            else ans += curr % 10;
            ans *= 10;
            // System.out.println(curr % 10);
            digits--;
        }

        if(num % 10 == 6 && !changed){
            ans += 9;
        }
        else ans += num % 10;
        return ans;
    }
}