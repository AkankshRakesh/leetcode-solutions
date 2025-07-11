class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int n = intervals.length;
        int low = intervals[0][0];
        int high = intervals[0][1];
        int index = 1;

        for(int i = 1; i < n; i++){
            if(intervals[i][0] <= high){
                if(intervals[i][1] > high) high = intervals[i][1];
            }
            else{
                index++;
                low = intervals[i][0];
                if(intervals[i][1] > high) high = intervals[i][1];
            }
        }
        int[][] arr = new int[index][2];
        index = 0;
        low = intervals[0][0];
        high = intervals[0][1];
        for(int i = 1; i < n; i++){
            if(intervals[i][0] <= high){
                if(intervals[i][1] > high) high = intervals[i][1];
            }
            else{
                int[] temp = new int[2];
                temp[0] = low;
                temp[1] = high;
                arr[index] = temp;
                index++;
                low = intervals[i][0];
                if(intervals[i][1] > high) high = intervals[i][1];
            }
        }
        int[] temp = new int[2];
        temp[0] = low;
        temp[1] = high;
        arr[index] = temp;
        return arr;
    }
}