class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        HashMap<Integer, ArrayList<int[]>> adj = new HashMap<>();
        for(int[] time : times){
            ArrayList<int[]> temp = adj.getOrDefault(time[0], new ArrayList<>());
            temp.add(new int[]{time[1], time[2]});
            adj.put(time[0], temp);
        }

        pq.offer(new int[]{k, 0});
        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);
        visited[k] = 0;
        while(!pq.isEmpty()){
            int size = pq.size();
            for(int i = 0; i < size; i++){
                int node = pq.peek()[0];
                int cost = pq.poll()[1];

                if(!adj.containsKey(node)) continue;
                for(int[] neig : adj.get(node)){
                    int nextNode = neig[0];
                    int nextCost = neig[1] + cost;

                    if(visited[nextNode] == -1 || visited[nextNode] > nextCost){
                        visited[nextNode] = nextCost;
                        pq.offer(new int[]{nextNode, nextCost});
                    }
                }
            }
        }

        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(visited[i] == -1) return -1;
            ans = Math.max(ans, visited[i]);
        }

        return ans;
    }
}