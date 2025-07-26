class Solution {
    class Pair {
        int node, weight;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, ArrayList<int[]>> adj = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, w});
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, w});
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
        int[] cost = new int[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        cost[1] = 0;
        pq.offer(new Pair(1, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;
            int w = current.weight;

            for (int[] neighbor : adj.getOrDefault(u, new ArrayList<>())) {
                int v = neighbor[0];
                int edgeWeight = neighbor[1];

                if (cost[v] > w + edgeWeight) {
                    cost[v] = w + edgeWeight;
                    pq.offer(new Pair(v, cost[v]));
                    parent[v] = u;
                }
            }
        }

        if (cost[n] == Integer.MAX_VALUE) {
            result.add(-1);
            return result;
        }

        LinkedList<Integer> path = new LinkedList<>();
        for (int at = n; at != -1; at = parent[at]) {
            path.addFirst(at);
        }

        result.add(cost[n]); 
        result.addAll(path);

        return result;
    }
}
