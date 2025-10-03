class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;
        int x1 = intervals[0][0];
        int y1 = intervals[0][1];
        // System.out.println(y1);
        for(int i = 1; i < intervals.length; i++){
            int x2 = intervals[i][0];
            int y2 = intervals[i][1];
            if(y1 <= x2){
                x1 = x2;
                y1 = y2;
            }
            else if(y1 > y2){
                y1 = y2;
                count++;
            }
            else count++;
        }

        return count;
    }
}