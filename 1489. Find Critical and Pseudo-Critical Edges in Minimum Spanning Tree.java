class Solution {
    class DSU{
        int[] parent;
        int[] rank;
        public DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
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
                parent[p1] = p2;
                rank[p2]++;
            }

            return true;
        }
    }
    public int weightOfMST(int[][] edges, int n, int u, int v){
        DSU dsu = new DSU(n);
        int w = 0;
        for(int[] edge : edges){
            if(edge[0] == u && edge[1] == v) continue;
            if(dsu.union(edge[0], edge[1])) w += edge[2];
        }

        int parent = dsu.find(0);
        for(int i = 1; i < n; i++) if(dsu.find(i) != parent) return Integer.MAX_VALUE;

        return w;
    }
    public int weightOfMSTIncluded(int[][] edges, int n, int u, int v, int edgeW){
        DSU dsu = new DSU(n);
        int w = edgeW;
        dsu.union(u, v);
        for(int[] edge : edges){
            if(dsu.union(edge[0], edge[1])) w += edge[2];
        }

        return w;
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edgesArr) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());

        int[][] edges = new int[edgesArr.length][4];
        for(int i = 0; i < edgesArr.length; i++){
            edges[i][0] = edgesArr[i][0]; 
            edges[i][1] = edgesArr[i][1]; 
            edges[i][2] = edgesArr[i][2]; 
            edges[i][3] = i; 
        }
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        
        int w = weightOfMST(edges, n, -1, -1);

        for(int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            int currW = weightOfMST(edges, n, edge[0], edge[1]);
            if(currW > w) ans.get(0).add(edge[3]);
            else if(currW == w){
                int includedW = weightOfMSTIncluded(edges, n, edge[0], edge[1], edge[2]);
                if(includedW == w) ans.get(1).add(edge[3]);
            }

            // System.out.println(i + " " + currW);
        }

        return ans;
    }
}