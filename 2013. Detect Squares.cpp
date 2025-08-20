class DetectSquares {
private:
    int coordMap[1001][1001];

public:
    DetectSquares() {
        for(int i = 0; i <= 1000; i++)
            for(int j = 0; j <= 1000; j++)
                coordMap[i][j] = 0;
    }
    
    void add(vector<int> point) {
        coordMap[point[0]][point[1]]++;
    }
    
    int count(vector<int> point) {
        int x = point[0];
        int y = point[1];
        int ans = 0;

        for (int indx = 0; indx < x; indx++) {
            if (coordMap[indx][y] == 0) continue;
            int sideLen = x - indx;

            if (y - sideLen >= 0 && coordMap[x][y - sideLen] != 0) {
                int indy = y - sideLen;
                if (coordMap[indx][indy] != 0)
                    ans += coordMap[indx][y] * coordMap[x][indy] * coordMap[indx][indy];
            }

            if (y + sideLen <= 1000 && coordMap[x][y + sideLen] != 0) {
                int indy = y + sideLen;
                if (coordMap[indx][indy] != 0)
                    ans += coordMap[indx][y] * coordMap[x][indy] * coordMap[indx][indy];
            }
        }

        for (int indx = x + 1; indx <= 1000; indx++) {
            if (coordMap[indx][y] == 0) continue;
            int sideLen = indx - x;

            if (y - sideLen >= 0 && coordMap[x][y - sideLen] != 0) {
                int indy = y - sideLen;
                if (coordMap[indx][indy] != 0)
                    ans += coordMap[indx][y] * coordMap[x][indy] * coordMap[indx][indy];
            }

            if (y + sideLen <= 1000 && coordMap[x][y + sideLen] != 0) {
                int indy = y + sideLen;
                if (coordMap[indx][indy] != 0)
                    ans += coordMap[indx][y] * coordMap[x][indy] * coordMap[indx][indy];
            }
        }

        return ans;
    }
};
