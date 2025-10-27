class Solution {
    public int numberOfBeams(String[] bank) {
        int ans = 0;
        int pastRow = -1;
        for(String row : bank){
            int currCount = 0;
            for(int i = 0; i < row.length(); i++){
                if(row.charAt(i) == '1') currCount++;
            }

            if(currCount == 0) continue;
            if(pastRow != -1) ans += (pastRow * currCount);
            pastRow = currCount;
        }

        return ans;
    }
}