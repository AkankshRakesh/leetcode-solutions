class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        HashMap<Integer, ArrayList<double[]>> adj = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            ArrayList<double[]> arr1 = adj.getOrDefault(edge[0], new ArrayList<>());
            ArrayList<double[]> arr2 = adj.getOrDefault(edge[1], new ArrayList<>());

            arr1.add(new double[]{edge[1], succProb[i]});
            arr2.add(new double[]{edge[0], succProb[i]});

            adj.put(edge[0], arr1);
            adj.put(edge[1], arr2);
        }

        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.offer(new double[]{start, 1});

        double[] visitedCost = new double[n];
        visitedCost[start] = 1;

        while(!pq.isEmpty()){
            double[] node = pq.poll();
            int currNode = (int)node[0];
            double currCost = node[1];
            if (currCost < visitedCost[currNode]) continue;

            if(!adj.containsKey(currNode)) continue;
            for(double[] neig : adj.get(currNode)){
                double nextCost = neig[1];
                nextCost *= currCost;
                int nextNode = (int)neig[0];

                if(visitedCost[nextNode] < nextCost){
                    visitedCost[nextNode] = nextCost;
                    pq.offer(new double[]{nextNode, nextCost});
                }
            }
        }

        return visitedCost[end];
    }
}