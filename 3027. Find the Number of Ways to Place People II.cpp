class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a,b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]));
        int n = points.length;
        if(n == 2){
            if(points[0][0] >= points[1][0] && points[0][1] <= points[1][1]) return 1;
            if(points[1][0] >= points[0][0] && points[1][1] <= points[0][1]) return 1;
            return 0;
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            int[] pointA = points[i];
            int xMin = pointA[0] - 1;
            int xMax = Integer.MAX_VALUE;
            int yMin = Integer.MIN_VALUE;
            int yMax = pointA[1] + 1;

            for (int j = i + 1; j < points.length; j++) {
                int[] pointB = points[j];
                if (
                    pointB[0] > xMin &&
                    pointB[0] < xMax &&
                    pointB[1] > yMin &&
                    pointB[1] < yMax
                ) {
                    ans++;
                    xMin = pointB[0];
                    yMin = pointB[1];
                }
            }
        }

        return ans;
    }
}