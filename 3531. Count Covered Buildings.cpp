class Solution {
public:
    int countCoveredBuildings(int n, vector<vector<int>>& buildings) {
        unordered_map<int, vector<int>> xAxis;
        unordered_map<int, vector<int>> yAxis;

        for (int i = 0; i < buildings.size(); i++) {
            int x = buildings[i][0];
            int y = buildings[i][1];

            if (xAxis.count(x)) {
                vector<int>& coords = xAxis[x];
                coords[0] = min(coords[0], y);
                coords[1] = max(coords[1], y);
            } else {
                xAxis[x] = {y, y};
            }

            if (yAxis.count(y)) {
                vector<int>& coords = yAxis[y];
                coords[0] = min(coords[0], x);
                coords[1] = max(coords[1], x);
            } else {
                yAxis[y] = {x, x};
            }
        }

        int ans = 0;
        for (auto& coords : buildings) {
            int x = coords[0];
            int y = coords[1];

            vector<int>& xCoords = xAxis[x];
            vector<int>& yCoords = yAxis[y];

            if (xCoords[0] != y && xCoords[1] != y && yCoords[0] != x && yCoords[1] != x)
                ans++;
        }

        return ans;
    }
};
