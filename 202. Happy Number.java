class Solution {
    public boolean isHappy(int n) {
        while(true){
            if(n == 1 || n == 7) return true;
            else if(n < 10) return false;

            int temp = 0;
            while(n > 0){
                temp += (n % 10) * (n % 10);
                n /= 10;
            }
            // System.out.println(temp);
            n = temp;
        }
    }
}