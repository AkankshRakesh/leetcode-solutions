class Solution {
    public int maxDiff(int num) {
        String numString = String.format("%d", num);
        int n = numString.length();

        char digForMax = '0';
        boolean foundDigForMax = false;
        int maxDig = 0;

        int minDig;
        char digForMin = 'a';
        boolean foundDigForMin = false;
        char chFirst = numString.charAt(0);
        if(chFirst != '1'){
            digForMin = chFirst;
            minDig = 1;
            foundDigForMin = true;
        }
        else{
            for(int i = 1; i < n; i++){
                if(numString.charAt(i) != '1' && numString.charAt(i) != '0'){
                    digForMin = numString.charAt(i);
                    foundDigForMin = true;
                    break;
                }
            }
            minDig = 1;
        }

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
        if(!foundDigForMin) return maxDig - num;
        if(chFirst != '1'){
            for(int i = 1; i < n; i++){
                char ch = numString.charAt(i);
                if(digForMin == ch){
                    if(i != n - 1){
                        minDig *= 10;
                        minDig += 1;
                    }
                    else{
                        minDig *= 10;
                        minDig += 1;
                    }
                }
                else{
                    minDig *= 10;
                    minDig += Integer.parseInt(String.valueOf(ch));
                }
            }
        }
        else{
            for(int i = 1; i < n; i++){
                char ch = numString.charAt(i);
                if(digForMin == ch){
                    minDig *= 10;
                }
                else{
                    minDig *= 10;
                    minDig += Integer.parseInt(String.valueOf(ch));
                }
            }
        }
        System.out.println(minDig);
        return maxDig - minDig;
    }
}