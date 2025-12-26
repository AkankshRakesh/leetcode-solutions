class Solution {
    public int bestClosingTime(String customers) {
        int yCount = 0, nCount = 0;
        for(char ch : customers.toCharArray()) if(ch == 'Y') yCount++;
        int ans = yCount;
        int index = 0;
        for(int i = 0; i < customers.length(); i++){
            char ch = customers.charAt(i);
            if(ch == 'Y') yCount--;
            else nCount++;

            if(ans > nCount + yCount){
                ans = nCount + yCount;
                index = i + 1;
            }
        }

        // if(ans )
        return index;
    }
}