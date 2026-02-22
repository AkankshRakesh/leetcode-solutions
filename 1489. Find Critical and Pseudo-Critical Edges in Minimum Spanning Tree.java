class Solution {
    public class DSU{
        int[] parent;
        int[] rank;
        public DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int vertex){
            if(parent[vertex] != vertex) return parent[vertex] = find(parent[vertex]);
            return vertex;
        }

        public boolean union(int u, int v){
            int p1 = find(u);
            int p2 = find(v);
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
    public int kruskal(int n, int[][] edges, int skipIndex, int pickIndex){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        int index = 0;
        int ans = 0;

        for(int[] edge : edges){
            if(index == skipIndex){
                index++;
                continue;
            }
            pq.offer(edge);
            index++;
        }

        DSU dsu = new DSU(n);
        if(pickIndex != -1 && dsu.union(edges[pickIndex][0], edges[pickIndex][1])){
            ans += edges[pickIndex][2];
        }

        while(!pq.isEmpty()){
            int[] edge = pq.poll();
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            if(dsu.union(u, v)){
                ans += weight;
            }
        }

        int parent = dsu.find(0);
        for(int i = 1; i < n; i++){
            if(parent != dsu.find(i)) return Integer.MAX_VALUE;
        }

        return ans;
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int minWeight = kruskal(n, edges, -1, -1);
        // System.out.println(minWeight);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        int index = 0;
        for(int[] edge : edges){
            if(kruskal(n, edges, index, -1) > minWeight) ans.get(0).add(index);
            else if(kruskal(n, edges, -1, index) == minWeight) ans.get(1).add(index);

            index++;
        }

        return ans;
    }
}