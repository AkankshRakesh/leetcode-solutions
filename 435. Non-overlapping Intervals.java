class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        int prevInt = intervals[0][1];
        int ans = 0;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= prevInt){
                prevInt = intervals[i][1];
                continue;
            }
            else if(intervals[i][0] < prevInt){
                if(intervals[i][1] < prevInt){
                    ans++;
                    prevInt = intervals[i][1];
                }
                else ans++;
            }
        }

        return ans;
    }
}