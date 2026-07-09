class Solution {
    class DSU{
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
                parent[p2] = p1;
            }
            else{
                parent[p2] = p1;
                rank[p1]++;
            }

            return true;
        }
    }
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        DSU dsu = new DSU(n);
        
        for(int i = 1; i < n; i++){
            if(Math.abs(nums[i] - nums[i - 1]) <= maxDiff){
                dsu.union(i, i - 1);
            }
        }

        boolean[] ans = new boolean[queries.length];

        for(int i = 0; i < queries.length; i++){
            int[] query = queries[i];
            if(dsu.find(query[0]) == dsu.find(query[1])) ans[i] = true;
            else ans[i] = false;
        }

        return ans;
    }
}