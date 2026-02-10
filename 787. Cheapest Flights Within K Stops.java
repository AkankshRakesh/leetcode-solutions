class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, ArrayList<int[]>> adj = new HashMap<>();
        for(int[] flight : flights){
            ArrayList<int[]> temp = adj.getOrDefault(flight[0], new ArrayList<>());
            temp.add(new int[]{flight[1], flight[2]});
            adj.put(flight[0], temp);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{src, 0, 0});
        int[][] visited = new int[n][k + 2];
        for(int i = 0; i < n; i++){
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        visited[src][0] = 0;

        while(!pq.isEmpty()){
            int node = pq.peek()[0];
            int cost = pq.peek()[1];
            int stops = pq.poll()[2];

            if(stops > k + 1) continue;
            if(node == dst) return cost;
            if(!adj.containsKey(node)) continue;

            for(int[] neig : adj.get(node)){
                int nextNode = neig[0];
                int nextCost = cost + neig[1];
                int nextStops = stops + 1;
                if(nextStops > k + 1) continue;

                if(visited[nextNode][nextStops] > nextCost){
                    pq.offer(new int[]{nextNode, nextCost, nextStops});
                    visited[nextNode][nextStops] = nextCost;
                }
            }
        }

        return -1;
    }
}