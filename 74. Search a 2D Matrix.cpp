class Solution {
public:
    bool searchMatrix(const vector<vector<int>>& matrix, int target) {
        int n = matrix.size();
        int m = matrix[0].size();
        int left = 0, right = n * m;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (matrix[mid / m][mid % m] == target) return true;
            else if (matrix[mid / m][mid % m] < target) left = mid + 1;
            else right = mid;
        }

        return false;
    }
};