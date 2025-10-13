class Solution {
    int[] parent;
    int[] rank;

    public int find(int n){
        if(parent[n] != n) parent[n] = find(parent[n]);
        return parent[n];
    }

    public boolean union(int u, int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv) return false;

        if(rank[pu] > rank[pv]){
            parent[pv] = pu;
        }
        else if(rank[pu] < rank[pv]){
            parent[pu] = pv;
        }
        else{
            parent[pu] = pv;
            rank[pu]++;
        }

        return true;
    }

    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        rank = new int[edges.length + 1];

        for(int i = 0; i <= edges.length; i++){
            parent[i] = i;
            rank[i] = 0;
        }

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            if(!union(u, v)) return edges[i];
        }

        return new int[0];
    }
}