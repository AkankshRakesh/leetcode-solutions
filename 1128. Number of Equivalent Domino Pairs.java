class Solution {
    public int numEquivDominoPairs(int[][] dom) {
        int[] countTable = new int[100];
        int res = 0;
        for(int i = 0; i < dom.length; i++){
            int num = dom[i][0] > dom[i][1] ? dom[i][1] * 10 + dom[i][0] : dom[i][0] * 10 + dom[i][1];
            if(countTable[num] != 0) res += countTable[num];
            countTable[num]++;
        }
        return res;
    }
}