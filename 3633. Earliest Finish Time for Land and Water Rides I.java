class Solution {
    public int getTime(int[] lst, int[] ld, int[] wst, int[] wd){
        int n = lst.length;
        int ind = 0;
        int leastTime = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(lst[i] + ld[i] < leastTime){
                ind = i;
                leastTime = lst[i] + ld[i];
            }
        }

        int m = wst.length;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            int buffer = 0;
            if(leastTime < wst[i]) buffer = wst[i] - leastTime;

            if(buffer + wd[i] < ans) ans = buffer + wd[i];
        }

        return leastTime + ans;
    }
    public int earliestFinishTime(int[] lst, int[] ld, int[] wst, int[] wd) {
        return Math.min(getTime(lst, ld, wst, wd), getTime(wst, wd, lst, ld));
    }
}