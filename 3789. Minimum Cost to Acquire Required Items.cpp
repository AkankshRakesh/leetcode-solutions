class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long x = (long)need1 * cost1;
        long y = (long)need2 * cost2;
        long z = Math.max(need1, need2) * (long)costBoth;
        long p = 0;
        if(need1 > need2){
            p += (long) costBoth * need2;
            p += ((long)cost1 * (need1 - need2));
        }
        else{
            p += (long) costBoth * need1;
            p += ((long)cost2 * (need2 - need1));
        }

        return Math.min(x + y, Math.min(z, p));
    }
}