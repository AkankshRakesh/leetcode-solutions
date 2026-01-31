class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, ArrayList<int[]>> adj = new HashMap<>();
        for(int[] flight : flights){
            ArrayList<int[]> temp = adj.getOrDefault(flight[0], new ArrayList<>());
            temp.add(new int[]{flight[1], flight[2]});
            adj.put(flight[0], temp);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        k++;
        boolean[] visited = new boolean[n];
        int[][] dp = new int[n][k + 2];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);

        pq.offer(new int[]{src, 0, 0});
        dp[src][0] = 0;
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int vertex = node[0];
            int cost = node[1];
            int stops = node[2];
            if (cost > dp[vertex][stops]) continue;
            if(stops > k) continue;
            if(vertex == dst) return cost;

            
            if(!adj.containsKey(vertex)) continue;
            for(int[] neig : adj.get(vertex)){
                int nextCost = neig[1] + cost;
                int nextStop = stops + 1;
                
                if(nextCost < dp[neig[0]][nextStop]){
                    dp[neig[0]][nextStop] = nextCost;
                    pq.offer(new int[]{neig[0], neig[1] + cost, stops + 1});
                }
            }
        }

        return -1;
    }
}