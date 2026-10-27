class Solution {
public:
    vector<string> createGrid(int n, int m) {
        vector<string> ans(n);

        for (int i = 0; i < n; i++) {
            string sb;
            sb += ".";

            if (i == n - 1) {
                for (int j = 1; j < m; j++) sb += ".";
            }
            else {
                for (int j = 1; j < m; j++) sb += "#";
            }

            ans[i] = sb;
        }

        return ans;
    }
};