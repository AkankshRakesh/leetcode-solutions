#include <vector>
#include <queue>
using namespace std;

class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int n = image.size();
        int m = image[0].size();
        vector<vector<int>> newImage = image;
        vector<vector<bool>> visited(n, vector<bool>(m, false));
        queue<pair<int, int>> q;
        q.push({sr, sc});
        visited[sr][sc] = true;
        int startPix = image[sr][sc];
        newImage[sr][sc] = color;

        vector<pair<int, int>> dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        while (!q.empty()) {
            auto [row, col] = q.front();
            q.pop();

            for (auto [dr, dc] : dirs) {
                int nRow = row + dr;
                int nCol = col + dc;

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
                    image[nRow][nCol] == startPix && !visited[nRow][nCol]) {
                    visited[nRow][nCol] = true;
                    newImage[nRow][nCol] = color;
                    q.push({nRow, nCol});
                }
            }
        }

        return newImage;
    }
};
