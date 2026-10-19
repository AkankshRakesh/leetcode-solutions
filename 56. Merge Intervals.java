class Solution {
    public boolean isOverlap(int x1, int y1, int x2, int y2){
        if(x2 <= y1) return true;
        return false;
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        ArrayList<int[]> res = new ArrayList<>();
        int index = 0;
        while(index < intervals.length){
            int maxR = intervals[index][1];
            int minL = intervals[index][0];

            while(index + 1 < intervals.length && isOverlap(minL, maxR, intervals[index + 1][0], intervals[index + 1][1])){
                maxR = Math.max(maxR, intervals[index + 1][1]);
                index++;
            }

            res.add(new int[]{minL, maxR});
            index++;
        }

        int[][] ans = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }

        return ans;
    }
}