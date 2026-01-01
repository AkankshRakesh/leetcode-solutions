class Solution {
    public int[] plusOne(int[] digits) {
        int[] num = new int[digits.length + 1];
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            int currDigit = digits[i] + carry;
            if(currDigit == 10) num[i + 1] = 0;
            else{
                num[i + 1] = currDigit;
                carry = 0;
            }
        }
        if(carry == 0){
            int[] ansArr = new int[digits.length];
            for(int i = 1; i <= digits.length; i++) ansArr[i - 1] = num[i];
            return ansArr;
        }
        num[0] = carry;
        return num;
    }
}