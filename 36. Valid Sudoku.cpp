#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        int n = board.size();
        int m = board[0].size();

        // 3D arrays for row and col tracking
        vector<vector<vector<bool>>> row(n, vector<vector<bool>>(m, vector<bool>(9, false)));
        vector<vector<vector<bool>>> col(n, vector<vector<bool>>(m, vector<bool>(9, false)));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i > 0) {
                    for (int k = 0; k < 9; k++) {
                        row[i][j][k] = row[i - 1][j][k];
                    }
                }
                if (j > 0) {
                    for (int k = 0; k < 9; k++) {
                        col[i][j][k] = col[i][j - 1][k];
                    }
                }

                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if (row[i][j][num - 1] || col[i][j][num - 1]) 
                        return false;
                    row[i][j][num - 1] = true;
                    col[i][j][num - 1] = true;
                }
            }
        }

        int currI = 0, currJ = 0;
        for (int c = 0; c < 9; c++) {
            unordered_set<int> hs;
            for (int i = currI; i < currI + 3; i++) {
                for (int j = currJ; j < currJ + 3; j++) {
                    if (board[i][j] == '.') continue;
                    int num = board[i][j] - '0';
                    if (hs.count(num)) return false;
                    hs.insert(num);
                }
            }
            currJ += 3;
            if (currJ >= m) {
                currJ = 0;
                currI += 3;
            }
        }

        return true;
    }
};
