class Solution {
    public int rotatedDigits(int n) {
        int ans = 0;
        int[] nums = new int[5];
        Arrays.fill(nums, -1);
        for(int i = 1; i <= n; i++){
            int digits = i;
            int index = 0;
            boolean becameInvalid = false;

            while(digits != 0){
                int digit = digits % 10;

                if(digit == 2) nums[index] = 5;
                else if(digit == 5) nums[index] = 2;
                else if(digit == 6) nums[index] = 9;
                else if(digit == 9) nums[index] = 6;
                else if(digit == 0 || digit == 1 || digit == 8) nums[index] = digit;
                else{
                    becameInvalid = true;
                    break;
                }

                digits /= 10;
                if(digits != 0) index++;
            }
            if(becameInvalid) continue;

            int flippedNum = 0;
            for(int j = index; j >= 0; j--){
                flippedNum *= 10;
                flippedNum += nums[j];
            }

            if(flippedNum != i) ans++;
        }

        return ans;
    }
}