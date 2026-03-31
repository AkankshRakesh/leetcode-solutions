public class Solution {
    public static class DSU{
        int[] parent;
        int[] rank;
        public DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int n){
            if(parent[n] != n) return parent[n] = find(parent[n]);
            return n;
        }

        public boolean union(int x, int y){
            int p1 = find(x);
            int p2 = find(y);
            if(p1 == p2) return false;
            if(rank[p1] < rank[p2]){
                parent[p1] = p2;
            }
            else if(rank[p1] > rank[p2]){
                parent[p1] = p2;
            }
            else{
                parent[p1] = p2;
                rank[p2]++;
            }
            return true;
        }
    }
    public static int[] numOfIslandsII(int n, int m, int[][] q) {
        DSU dsu = new DSU(n*m);
        int ans[] = new int[q.length];
        int[][] grid = new int[n][m];
        int curr = 0;
        int index = 0;
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};
        for(int[] query : q){
            int i = query[0];
            int j = query[1];
            int dist = (i * m) + j;
            curr++;
            for(int ind = 0; ind < 4; ind++){
                int x = i + dx[ind];
                int y = j + dy[ind];
                int nextDist = (x * m) + y;
                if(x < 0 || y < 0 || x >= n || y >= m) continue;
                if(grid[x][y] == 1 && dsu.union(dist, nextDist)) curr--;
            }
            grid[i][j] = 1;
            ans[index++] = curr;
        }


        return ans;
    }
}