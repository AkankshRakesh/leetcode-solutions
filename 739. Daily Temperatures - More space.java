class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] tempInd = new int[71];
        int[] ans = new int[n];
        
        tempInd[temp[n - 1] - 30] = n - 1;
        for(int i = n - 2; i >= 0; i--){
            int currTemp = temp[i] - 30;
            int higherTempInd = n;
            for(int j = currTemp + 1; j <= 70; j++){
                if(tempInd[j] != 0) higherTempInd = Math.min(tempInd[j], higherTempInd);
            }
            // System.out.println(higherTempInd);
            tempInd[currTemp] = i;

            if(higherTempInd != n) ans[i] = higherTempInd - i;
        }

        return ans;
    }
}