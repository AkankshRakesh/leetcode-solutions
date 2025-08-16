class Solution {
    static class Edge {
        int to, w;
        Edge(int t, int w) { this.to = t; this.w = w; }
    }

    public int minCost(int n, int[][] edges) {
        List<Edge>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj[u].add(new Edge(v, w));     // normie 
            adj[v].add(new Edge(u, 2*w));   
        }

        long[][] dist = new long[n][2];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], Long.MAX_VALUE);
        dist[0][0] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0, 0}); // {cost, node, switchUsed}

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1], s = (int) cur[2];

            if (d > dist[u][s]) continue;

            for (Edge e : adj[u]) {
                int v = e.to;
                long w = e.w;
                int ns = (w % 2 == 0) ? 1 : s; // if reversed edge, switch used
                if (dist[v][ns] > d + w) {
                    dist[v][ns] = d + w;
                    pq.offer(new long[]{dist[v][ns], v, ns});
                }
            }
        }

        long ans = Math.min(dist[n-1][0], dist[n-1][1]);
        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }
}
