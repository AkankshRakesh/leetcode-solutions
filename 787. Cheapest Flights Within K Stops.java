class Solution {
    class Node{
        int jump;
        int cost;
        int node;
        public Node(int node, int cost, int jump){
            this.node = node;
            this.cost = cost;
            this.jump = jump;
        }
    }
    class Pair{
        int node;
        int cost;
        public Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, ArrayList<Pair>> adj = new HashMap<>();

        for(int[] flight : flights){
            if(!adj.containsKey(flight[0])){
                ArrayList<Pair> arr = new ArrayList<>();
                arr.add(new Pair(flight[1], flight[2]));
                adj.put(flight[0], arr);
            }
            else adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        pq.offer(new Node(src, 0, 0));

        int[][] best = new int[n][k + 2];
        for (int[] row : best) Arrays.fill(row, Integer.MAX_VALUE);
        best[src][0] = 0;

        while(!pq.isEmpty()){
            Node top = pq.poll();

            if(top.node == dst) return top.cost;
            if(top.jump > k || !adj.containsKey(top.node)) continue;
            if (top.cost > best[top.node][top.jump]) continue;

            for(Pair neig : adj.get(top.node)){
                int newCost = top.cost + neig.cost;
                int nextJump = top.jump + 1;

                if (newCost < best[neig.node][nextJump]) {
                    best[neig.node][nextJump] = newCost;
                    pq.offer(new Node(neig.node, newCost, nextJump));
                }
            }
        }

        return -1;
    }
}