class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0, right = n * m;

        while(left < right){
            int mid = left + (right - left) / 2;

            // System.out.println(mid + "-" + left + "-" + right + "=" + matrix[mid / m][mid % m] + " for " + target);
            if(matrix[mid / m][mid % m] == target) return true;
            else if(matrix[mid / m][mid % m] < target) left = mid + 1;
            else right = mid;
        }

        return false;
    }
}