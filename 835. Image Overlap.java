class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        ArrayList<int[]> ones1 = new ArrayList<>();
        ArrayList<int[]> ones2 = new ArrayList<>();
        int n = img1.length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(img1[i][j] == 1) ones1.add(new int[]{i, j});
                if(img2[i][j] == 1) ones2.add(new int[]{i, j});
            }
        }

        int[][] count = new int[2 * n - 1][2 * n - 1];

        int ans = 0;

        for (int[] a : ones1) {
            for (int[] b : ones2) {
                int dx = a[0] - b[0] + n - 1;
                int dy = a[1] - b[1] + n - 1;

                count[dx][dy]++;
                ans = Math.max(ans, count[dx][dy]);
            }
        }

        return ans;
    }
}