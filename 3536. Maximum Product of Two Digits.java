class Solution {
    public int maxProduct(int n) {
        int max = n % 10;
        n /= 10;
        int secondMax = n % 10;
        if(secondMax > max){
            secondMax = max;
            max = n % 10;
        }
        n /= 10;

        while(n != 0){
            int digit = n % 10;
            if(digit > max){
                secondMax = max;
                max = digit;
            }
            else if(digit > secondMax) secondMax = digit;

            n /= 10;
        }

        return max * secondMax;
    }
}