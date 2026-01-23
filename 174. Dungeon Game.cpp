#include <vector>
#include <algorithm>
#include <climits>

class Solution {
public:
    int calculateMinimumHP(std::vector<std::vector<int>>& dungeon) {
        int n = dungeon.size();
        int m = dungeon[0].size();

        dungeon[n - 1][m - 1] = std::max(1, 1 - dungeon[n - 1][m - 1]);
        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                if(i == n - 1 && j == m - 1) continue;

                int bottom = (i + 1 < n) ? dungeon[i + 1][j] : INT_MAX;
                int right = (j + 1 < m) ? dungeon[i][j + 1] : INT_MAX;

                dungeon[i][j] = std::min(bottom, right) - dungeon[i][j];
                dungeon[i][j] = std::max(1, dungeon[i][j]);
            }
        }

        return dungeon[0][0];
    }
};