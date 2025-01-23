int countServers(int** grid, int gridSize, int* gridColSize) {
    int rowSum[gridSize];
    int colSum[gridColSize[0]]; 

    for (int i = 0; i < gridSize; i++) rowSum[i] = 0;
    for (int j = 0; j < gridColSize[0]; j++) colSum[j] = 0;

    for (int i = 0; i < gridSize; i++) {
        for (int j = 0; j < gridColSize[0]; j++) {
            if (grid[i][j] == 1) {
                rowSum[i]++;
                colSum[j]++;
            }
        }
    }

    int ans = 0;
    for (int i = 0; i < gridSize; i++) {
        for (int j = 0; j < gridColSize[0]; j++) {
            if (grid[i][j] == 1 && (rowSum[i] > 1 || colSum[j] > 1)) {
                ans++;
            }
        }
    }

    return ans;
}
