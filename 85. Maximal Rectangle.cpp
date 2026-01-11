class Solution {
public:
    int maximalRectangle(vector<vector<char>>& matrix) {
        vector<int> arr(matrix[0].size());
        int ans = 0;

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix[0].size(); j++) {
                if (matrix[i][j] == '0') arr[j] = 0;
                else arr[j]++;
            }

            for (int j = 0; j < arr.size(); j++) {
                if (arr[j] == 0) continue;

                int minNum = arr[j];
                ans = max(ans, minNum);

                for (int k = j + 1; k < arr.size(); k++) {
                    if (arr[k] == 0) break;
                    minNum = min(minNum, arr[k]);
                    ans = max(ans, minNum * (k - j + 1));
                }
            }
        }

        return ans;
    }
};
