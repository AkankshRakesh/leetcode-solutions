class Solution {
    public class Pair{
        int v;
        int cost;
        public Pair(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
    }
    public int minCost(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Pair>> adj = new HashMap<>();
        for(int[] edge : edges){
            if(adj.containsKey(edge[0])) adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            else{
                ArrayList<Pair> temp = new ArrayList<>();
                temp.add(new Pair(edge[1], edge[2]));
                adj.put(edge[0], temp);
            }
            
            if(adj.containsKey(edge[1])) adj.get(edge[1]).add(new Pair(edge[0], edge[2] * 2));
            else{
                ArrayList<Pair> temp = new ArrayList<>();
                temp.add(new Pair(edge[0], edge[2] * 2));
                adj.put(edge[1], temp);
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        pq.offer(new Pair(0, 0));
        int currCost = 0;
        boolean[] visited = new boolean[n];

        while(!pq.isEmpty()){
            int vertex = pq.peek().v;
            int cost = pq.poll().cost;
            if(visited[vertex]) continue;
            currCost = cost;
            // System.out.println(vertex + "-" + currCost);
            visited[vertex] = true;
            if(vertex == n - 1) break;

            if(!adj.containsKey(vertex)) continue;
            for(Pair neig : adj.get(vertex)){
                if(!visited[neig.v]) pq.offer(new Pair(neig.v, neig.cost + currCost));
            } 
        }

        return currCost == 0 || !visited[n - 1] ? -1 : currCost;
    }
}