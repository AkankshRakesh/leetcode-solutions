class Solution {
    int[] rank, parent, minNode;

    public int find(int i) {
        if (parent[i] != i)
            parent[i] = find(parent[i]);
        return parent[i];
    }

    public void union(int x, int y) {
        int xRoot = find(x), yRoot = find(y);
        if (xRoot == yRoot) return;

        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
            minNode[yRoot] = Math.min(minNode[yRoot], minNode[xRoot]);
        } else if (rank[yRoot] < rank[xRoot]) {
            parent[yRoot] = xRoot;
            minNode[xRoot] = Math.min(minNode[xRoot], minNode[yRoot]);
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
            minNode[xRoot] = Math.min(minNode[xRoot], minNode[yRoot]);
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        rank = new int[c + 1];
        parent = new int[c + 1];
        minNode = new int[c + 1];
        boolean[] online = new boolean[c + 1];

        for (int i = 1; i <= c; i++) {
            parent[i] = i;
            minNode[i] = i; 
            online[i] = true;
        }
        for (int[] conns : connections)
            union(conns[0], conns[1]);

        Map<Integer, PriorityQueue<Integer>> roots = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int root = find(i);
            roots.putIfAbsent(root, new PriorityQueue<>());
            roots.get(root).offer(i);
        }

        List<Integer> result = new ArrayList<>();

        for (int[] query : queries) {
            int opt = query[0];
            int station = query[1];

            if (opt == 1) { 
                if (online[station]) {
                    result.add(station);
                    continue;
                }

                int root = find(station);
                PriorityQueue<Integer> heap = roots.get(root);

                while (heap != null && !heap.isEmpty() && !online[heap.peek()])
                    heap.poll();

                if (heap != null && !heap.isEmpty())
                    result.add(heap.peek());
                else
                    result.add(-1);
            } else if (opt == 2) { 
                online[station] = false;
            }
        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) ans[i] = result.get(i);
        return ans;
    }
}
