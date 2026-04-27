class Solution {
    public class DSU{
        int[] parent;
        int[] rank;
        public DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
            Arrays.fill(rank, 1);
        }

        public int find(int n){
            if(parent[n] != n) return parent[n] = find(parent[n]);
            return n;
        }

        public void union(int x, int y){
            int p1 = find(x);
            int p2 = find(y);
            if(p1 == p2) return;

            if(rank[p1] > rank[p2]){
                parent[p2] = p1;
            }
            else if(rank[p1] < rank[p2]){
                parent[p1] = p2;
            }
            else{
                parent[p1] = p2;
                rank[p2]++;
            }
        }
    }
    public boolean getDir(int[][] grid, int i, int j, int pi, int pj){
        if(i >= grid.length || j >= grid[0].length || i < 0 || j < 0) return false;
        switch(grid[i][j]){
            case 1:
                if((j + 1 == pj && i == pi) || (i == pi && j - 1 == pj)) return true;
                else return false;
            case 2:
                if((j == pj && i - 1 == pi) || (i + 1 == pi && j == pj)) return true;
                else return false;
            case 3:
                if((j - 1 == pj && i == pi) || (i - 1 == pi && j == pj)) return true;
                else return false;
            case 4:
                if((j + 1 == pj && i == pi) || (i + 1 == pi && j == pj)) return true;
                else return false;
            case 5:
                if((j == pj && i - 1 == pi) || (i == pi && j - 1 == pj)) return true;
                else return false;
            case 6:
                if((j + 1 == pj && i == pi) || (i - 1 == pi && j == pj)) return true;
                else return false;
        }
        return false;
    }
    public boolean hasValidPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        DSU dsu = new DSU(n * m);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int index = (i * m) + j;
                int[] dir1 = new int[]{0, 0};
                int[] dir2 = new int[]{0, 0};
                switch(grid[i][j]){
                    case 1:
                        dir1[1] = -1;
                        dir2[1] = -1;
                        break;
                    case 2:
                        dir1[0] = 1;
                        dir2[0] = -1;
                        break;
                    case 3:
                        dir1[0] = 1;
                        dir2[1] = -1;
                        break;
                    case 4:
                        dir1[0] = 1;
                        dir2[1] = 1;
                        break;
                    case 5:
                        dir1[0] = -1;
                        dir2[1] = -1;
                        break;
                    case 6:
                        dir1[0] = -1;
                        dir2[1] = 1;
                }
                int next1 = ((i + dir1[0]) * m) + (dir1[1] + j);
                int next2 = ((i + dir2[0]) * m) + (dir2[1] + j);
                if(getDir(grid, i + dir1[0], j + dir1[1], i, j)) dsu.union(index, next1);
                if(getDir(grid, i + dir2[0], j + dir2[1], i, j)) dsu.union(index, next2);
            }
        }

        return dsu.find(0) == dsu.find(n * m - 1);
    }
}