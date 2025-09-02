class Solution {
    public int numberOfPairs(int[][] points) {
        // Arrays.sort(points, (a,b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        int n = points.length;
        if(n == 2){
            if(points[0][0] >= points[1][0] && points[0][1] <= points[1][1]) return 1;
            if(points[1][0] >= points[0][0] && points[1][1] <= points[0][1]) return 1;
            return 0;
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            // System.out.println(points[i][1]);
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(points[j][1] < points[i][1] || points[j][0] > points[i][0]) continue;        
                boolean valid = true;
                for(int k = 0; k < n; k++){
                    if(k == i || k == j) continue;
                    if(points[k][1] >= points[i][1] && points[k][1] <= points[j][1] && points[k][0] >= points[j][0] && points[k][0] <= points[i][0]){
                        valid = false;
                        break;
                    }
                }
                if(valid) ans++;
            }
        }

        return ans;
    }
}