class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] arr = new int[matrix[0].length];
        int ans = 0;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '0') arr[j] = 0;
                else arr[j]++;
            }

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == 0) continue;

                int minNum = arr[j];
                ans = Math.max(ans, minNum);

                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[k] == 0) break;
                    minNum = Math.min(minNum, arr[k]);
                    ans = Math.max(ans, minNum * (k - j + 1));
                }
            }
        }

        return ans;
    }
}