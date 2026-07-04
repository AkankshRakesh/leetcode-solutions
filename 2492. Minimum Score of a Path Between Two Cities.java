class Solution {
    public class DSU{
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
            if(rank[p1] > rank[p2]){
                parent[p2] = p1;
            }
            else if(rank[p1] < rank[p2]){
                parent[p1] = p2;
            }
            else{
                parent[p2] = p1;
                rank[p1]++;
            }
            
            return true;
        }
    }
    public int minScore(int n, int[][] roads) {
        DSU dsu = new DSU(n + 1);
        int ans = Integer.MAX_VALUE;

        for(int[] road : roads){
            dsu.union(road[0], road[1]);
        }

        int targetParent = dsu.find(1);
        for(int[] road : roads){
            if(dsu.find(road[0]) == targetParent) ans = Math.min(ans, road[2]); 
        }

        return ans;
    }
}