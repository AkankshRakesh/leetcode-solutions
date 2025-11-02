class Solution {
public:
    void iterate(vector<vector<char>>& guarded, int x, int y, int n, int m) {
        for (int i = x - 1; i >= 0 && (guarded[i][y] == '-' || guarded[i][y] == '+'); i--)
            guarded[i][y] = '+';
        
        for (int i = x + 1; i < n && (guarded[i][y] == '-' || guarded[i][y] == '+'); i++)
            guarded[i][y] = '+';
        
        for (int j = y - 1; j >= 0 && (guarded[x][j] == '-' || guarded[x][j] == '+'); j--)
            guarded[x][j] = '+';
        
        for (int j = y + 1; j < m && (guarded[x][j] == '-' || guarded[x][j] == '+'); j++)
            guarded[x][j] = '+';
    }

    int countUnguarded(int n, int m, vector<vector<int>>& guards, vector<vector<int>>& walls) {
        vector<vector<char>> guarded(n, vector<char>(m, '-'));

        for (auto& gc : guards) guarded[gc[0]][gc[1]] = 'G';
        for (auto& wc : walls) guarded[wc[0]][wc[1]] = 'W';

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (guarded[i][j] == 'G') {
                    iterate(guarded, i, j, n, m);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (guarded[i][j] == '-') ans++;
            }
        }

        return ans;
    }
};
