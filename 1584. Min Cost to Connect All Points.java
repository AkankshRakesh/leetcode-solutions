class Solution {
    class Pair{
        int point;
        int dist;
        public Pair(int point, int dist){
            this.point = point;
            this.dist = dist;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                int x2 = points[j][0];
                int y2 = points[j][1];
                temp.add(j);
            }
            adj.put(i, temp);
        }


        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        int nodesConnected = 0;
        int ans = 0;
        pq.offer(new Pair(0, 0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(visited[p.point]) continue;
            
            ans += p.dist;
            visited[p.point] = true;
            for(int neig : adj.get(p.point)){
                if(!visited[neig]){
                    int x1 = points[p.point][0];
                    int y1 = points[p.point][1];
                    int x2 = points[neig][0];
                    int y2 = points[neig][1];
                    pq.offer(new Pair(neig, Math.abs(x1 - x2) + Math.abs(y1 - y2)));
                }
            }
        }

        return ans;
    }
}