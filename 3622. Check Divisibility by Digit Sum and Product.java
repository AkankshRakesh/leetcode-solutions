class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0, product = 1;
        int temp = n;
        while(temp != 0){
            sum += temp % 10;
            product *= temp % 10;
            temp /= 10;
        }

        if(n % (sum + product) == 0) return true;
        return false;
    }
}