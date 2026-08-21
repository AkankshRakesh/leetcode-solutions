class Solution {
    public boolean bfs(HashMap<Integer, ArrayList<int[]>> adj, int vertex, int[] color, int target) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(vertex);
        color[vertex] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int[] neig : adj.get(u)) {
                int v = neig[0];
                int dist = neig[1];

                if (dist >= target) continue;

                if (color[v] == -1) {
                    color[v] = 1 - color[u];
                    q.offer(v);
                } else if (color[v] == color[u]) {
                    return false;
                }
            }
        }

        return true;
    }
    public boolean isPossible(int[][] points, int target, HashMap<Integer, ArrayList<int[]>> adj){
        int[] color = new int[points.length];
        Arrays.fill(color, -1);
        
        for(int i = 0; i < points.length; i++){
            if(color[i] == -1 && !bfs(adj, i, color, target)) return false;
        }

        return true;
    }
    public int maxPartitionFactor(int[][] points) {
        if (points.length == 2) return 0;
        
        int left = 0, right = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int dist = Math.abs(points[i][0] - points[j][0])
                         + Math.abs(points[i][1] - points[j][1]);

                right = Math.max(right, dist);
            }
        }

        HashMap<Integer, ArrayList<int[]>> adj = new HashMap<>();
        for(int i = 0; i < points.length; i++){
            int[] x = points[i];
            ArrayList<int[]> arr = adj.getOrDefault(i, new ArrayList<>());

            for(int j = 0; j < points.length; j++){
                if(i == j) continue;
                int[] y = points[j];

                int dist = Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
                arr.add(new int[]{j, dist});
            }
            adj.put(i, arr);
        }

        int ans = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(isPossible(points, mid, adj)){
                ans = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }

        return ans;
    }
}