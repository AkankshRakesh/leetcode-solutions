class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, ArrayList<int[]>> adj = new HashMap<>();
        boolean[] visited = new boolean[n + 1];
        
        for(int[] time : times){
            ArrayList<int[]> temp = adj.getOrDefault(time[0], new ArrayList<>());
            temp.add(new int[]{time[1], time[2]});
            adj.put(time[0], temp);
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        q.offer(new int[]{k, 0});

        int ans = 0;
        while(!q.isEmpty()){
            int[] node = q.poll();
            int vertex = node[0];
            int cost = node[1];
            
            if(visited[vertex]) continue;
            visited[vertex] = true;
            ans = Math.max(ans, cost);
            // System.out.println(vertex + "-" + cost);
            if(!adj.containsKey(vertex)) continue;

            for(int[] neig : adj.get(vertex)){
                if(!visited[neig[0]]) q.offer(new int[]{neig[0], cost + neig[1]});
            }
        }

        for(int i = 1; i <= n; i++) if(!visited[i]) return -1;

        return ans;
    }
}