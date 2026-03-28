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

        public void union(int x, int y){
            int p1 = find(x);
            int p2 = find(y);
            if(p1 == p2) return;

            if(rank[p1] < rank[p2]){
                parent[p1] = p2;
            }
            else if(rank[p1] > rank[p2]){
                parent[p2] = p1;
            }
            else{
                parent[p1] = p2;
                rank[p2]++;
            }
        }
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] qs) {
        Arrays.sort(edgeList, (a, b) -> Integer.compare(a[2], b[2]));
        int[][] queries = new int[qs.length][4];
        for(int i = 0; i < qs.length; i++){
            queries[i][0] = qs[i][0];
            queries[i][1] = qs[i][1];
            queries[i][2] = qs[i][2];
            queries[i][3] = i;
        }
        Arrays.sort(queries, (a, b) -> Integer.compare(a[2], b[2]));

        DSU dsu = new DSU(n);
        boolean[] ans = new boolean[queries.length];
        int index = 0;
        for(int i = 0; i < queries.length; i++){
            while(index < edgeList.length && edgeList[index][2] < queries[i][2]){
                dsu.union(edgeList[index][0], edgeList[index][1]);
                index++;
            }

            if(dsu.find(queries[i][0]) == dsu.find(queries[i][1])) ans[queries[i][3]] = true;
            else ans[queries[i][3]] = false;
        }

        return ans;
    }
}