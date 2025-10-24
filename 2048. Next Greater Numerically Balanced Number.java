class Solution {
    public int nextBeautifulNumber(int n) {
        if(n > 666666) return 1224444;

        n++;
        while(true){
            int[] freq = new int[10];
            int temp = n;
            while(temp != 0){
                freq[temp % 10]++;
                temp /= 10;
            }

            if(freq[0] != 0){
                n++;
                continue;
            }

            boolean isAns = true;
            for(int i = 1; i < 10; i++){
                if(freq[i] != 0 && freq[i] != i){
                    isAns = false;
                    break;
                }
            }
            
            if(isAns) break;
            n++;
        }

        return n;
    }
}