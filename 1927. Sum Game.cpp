class Solution {
    public boolean sumGame(String num) {
        long left = 0, right = 0;
        long leftSum = 0, rightSum = 0;
        for(int i = 0; i < num.length() / 2; i++){
            if(num.charAt(i) == '?') left++;
            else leftSum += num.charAt(i) - '0';
        }
        for(int i = num.length() / 2; i < num.length(); i++){
            if(num.charAt(i) == '?') right++;
            else rightSum += num.charAt(i) - '0';
        }

        return (left + right) % 2 == 1 || leftSum - rightSum != ((right - left) * 9) / 2;
    }
}