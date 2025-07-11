class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int n = intervals.length;
        int ans = 0;
        int last = 0;
        for(int i = 1; i < n; i++){
            if(intervals[i][0] < intervals[last][1]) ans++;
            else last = i;
        }

        return ans;
    }
}