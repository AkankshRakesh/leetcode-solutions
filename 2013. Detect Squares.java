class DetectSquares {
    int[][] coordMap = new int[1001][1001];
    public DetectSquares() {
        coordMap = new int[1001][1001];
    }
    
    public void add(int[] point) {
        coordMap[point[0]][point[1]]++;
    }
    
    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int ans = 0;
        for(int indx = 0; indx < x; indx++){
            if(coordMap[indx][y] == 0) continue;
            int sideLen = x - indx;
            if(y - sideLen >= 0 && coordMap[x][y - sideLen] != 0){
                int indy = y - sideLen;
                if(coordMap[indx][indy] != 0){
                    ans += coordMap[indx][y] * coordMap[x][indy] * coordMap[indx][indy];
                }
            }

            if(y + sideLen <= 1000 && coordMap[x][y + sideLen] != 0){
                int indy = y + sideLen;
                if(coordMap[indx][indy] != 0){
                    ans += coordMap[indx][y] * coordMap[x][indy] * coordMap[indx][indy];
                }
            }
        }
        for(int indx = x + 1; indx <= 1000; indx++){
            if(coordMap[indx][y] == 0) continue;
            int sideLen = indx - x;
            if(y - sideLen >= 0 && coordMap[x][y - sideLen] != 0){
                int indy = y - sideLen;
                if(coordMap[indx][indy] != 0){
                    ans += coordMap[indx][y] * coordMap[x][indy] * coordMap[indx][indy];
                }
            }

            if(y + sideLen <= 1000 && coordMap[x][y + sideLen] != 0){
                int indy = y + sideLen;
                if(coordMap[indx][indy] != 0){
                    ans += coordMap[indx][y] * coordMap[x][indy] * coordMap[indx][indy];
                }
            }
        }

        return ans;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */