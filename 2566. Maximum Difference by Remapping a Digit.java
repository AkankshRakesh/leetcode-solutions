class Solution {
    public int minMaxDifference(int num) {
        String numString = String.format("%d", num);
        int n = numString.length();

        char digForMax = '0';
        boolean foundDigForMax = false;
        int maxDig = 0;

        char digForMin = numString.charAt(0);
        int minDig = 0;

        for(int i = 0; i < n; i++){
            char ch = numString.charAt(i);
            if(foundDigForMax){
                if(digForMax == ch){
                    maxDig += 9;
                    if(i != n - 1) maxDig *= 10;
                }
                else{
                    maxDig += Integer.parseInt(String.valueOf(ch));
                    if(i != n - 1) maxDig *= 10;
                }
            }
            else{
                if(ch != '9'){
                    digForMax = ch;
                    foundDigForMax = true;

                }
                maxDig += 9;
                if(i != n - 1) maxDig *= 10;
            }
        }

        for(int i = 1; i < n; i++){
            char ch = numString.charAt(i);
            if(digForMin == ch){
                if(i != n - 1) minDig *= 10;
            }
            else{
                minDig += Integer.parseInt(String.valueOf(ch));
                if(i != n - 1) minDig *= 10;
            }
        }
        // System.out.println(maxDig);
        return maxDig - minDig;
    }
}