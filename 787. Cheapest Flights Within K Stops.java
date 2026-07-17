class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for(int i = 0; i <= k; i++){
            int[] tempDist = new int[n];
            for(int j = 0; j < n; j++) tempDist[j] = dist[j];

            for(int[] flight : flights){
                int u = flight[0];
                int v = flight[1];
                int cost = flight[2];
                if(dist[flight[0]] != Integer.MAX_VALUE && dist[flight[0]] + flight[2] < tempDist[flight[1]]){
                    tempDist[flight[1]] = dist[flight[0]] + flight[2];
                }
            }

            for(int j = 0; j < n; j++) dist[j] = tempDist[j];
        }
        
        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}