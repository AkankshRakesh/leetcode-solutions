class Solution {
    boolean flag = false;
    public void carrySum(int[] digits, int ind){
        if(ind < 0){
            flag = true;
            return;
        }
        if(digits[ind] == 9){
            digits[ind] = 0;
            carrySum(digits, ind - 1);
        }
        else digits[ind]++;
    }
    public int[] plusOne(int[] digits) {
        carrySum(digits, digits.length - 1);

        if(flag){
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            return ans;
        }

        return digits;
    }
}