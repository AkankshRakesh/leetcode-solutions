
class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[3], b[3])
        );

        HashMap<Integer, ArrayList<int[]>> adj = new HashMap<>();

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            ArrayList<int[]> arr = adj.getOrDefault(u, new ArrayList<>());
            arr.add(new int[]{v, w});
            adj.put(u, arr);
        }

        pq.offer(new int[]{0, labels.charAt(0) - 'a', 1, 0});

        int[][] dp = new int[n][k + 1];

        for(int[] row : dp){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dp[0][1] = 0;

        while(!pq.isEmpty()){
            int[] ele = pq.poll();

            int currNode = ele[0];
            int currLabel = ele[1];
            int labelCount = ele[2];
            int currCost = ele[3];

            if(dp[currNode][labelCount] < currCost) continue;

            if(!adj.containsKey(currNode)) continue;

            for(int[] neig : adj.get(currNode)){
                int nextNode = neig[0];
                int nextCost = neig[1] + currCost;
                int nextLabel = labels.charAt(nextNode) - 'a';

                int nextCount = nextLabel == currLabel
                    ? labelCount + 1 : 1;

                if(nextCount > k || nextCost >= dp[nextNode][nextCount])
                    continue;

                pq.offer(new int[]{
                    nextNode, nextLabel, nextCount, nextCost
                });

                dp[nextNode][nextCount] = nextCost;
            }
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 1; i <= k; i++){
            ans = Math.min(ans, dp[n - 1][i]);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
