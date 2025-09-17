class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int first = n, last = 0;
        for(int ind : right) first = Math.min(first, ind);
        for(int ind : left) last = Math.max(last, ind);

        return Math.max(last, n - first);
    }
}