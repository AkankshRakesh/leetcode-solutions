class Solution {
    public boolean checkDivisibility(int n) {
        // if(n <= 10) return false;
        int prod = 1, sum = 0;
        int temp = n;
        while(temp != 0){
            int lastDig = temp%10;
            prod *= lastDig;
            sum += lastDig;
            temp /= 10;
        }
        // System.out.println(prod);
        if(prod + sum == 0) return false;
        if(n % (prod + sum) == 0) return true;
        return false;
    }
}