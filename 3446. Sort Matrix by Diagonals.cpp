class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for (int row = n - 1; row >= 0; row--) {
            sortDiagonal(grid, row, 0, n, m, true);
        }

        for (int col = 1; col < m; col++) {
            sortDiagonal(grid, 0, col, n, m, false);
        }

        return grid;
    }

    private void sortDiagonal(int[][] grid, int row, int col, int n, int m, boolean flip) {
        List<Integer> list = new ArrayList<>();
        int r = row, c = col;

        while (r < n && c < m) {
            list.add(grid[r][c]);
            r++;
            c++;
        }
        if(!flip) Collections.sort(list);
        else Collections.sort(list, Collections.reverseOrder());

        r = row; 
        c = col;
        int idx = 0;
        while (r < n && c < m) {
            grid[r][c] = list.get(idx++);
            r++;
            c++;
        }
    }
}