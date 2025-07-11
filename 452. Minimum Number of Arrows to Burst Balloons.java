class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int right = points[0][1];
        int n = points.length;
        int ans = 1;

        for(int i = 1; i < n; i++){
            if(points[i][0] > right){
                ans++;
                right = points[i][1];
            }
            else{
                if(right > points[i][1]) right = points[i][1];
            }
        }
        // if(points[n - 1][0] < right){
        //     ans++;
        // }
        return ans;
    }
}