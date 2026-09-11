class Solution {
    public int totalNumbers(int[] digits) {
        int[] arr = new int[digits.length];
        for(int i = 0; i < digits.length; i++) arr[i] = digits[i];
        int ans = 0;

        for(int num = 100; num <= 999; num += 2){
            int tempNum = num;
            boolean isMatch = true;
            while(tempNum != 0){
                int neededDigit = tempNum % 10;
                boolean found = false;

                for(int i = 0; i < arr.length; i++){
                    if(neededDigit == arr[i]){
                        found = true;
                        arr[i] = -1;
                        break;
                    }
                }

                if(!found){
                    isMatch = false;
                    break;
                }
                tempNum /= 10;
            }

            if(isMatch) ans++;
            for(int i = 0; i < digits.length; i++) arr[i] = digits[i];
        }

        return ans;
    }
}