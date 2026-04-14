class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int[] inDeg = new int[n];
        for(int i = 0; i < n; i++) adj.put(i, new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            inDeg[edge[0]]++;
            inDeg[edge[1]]++;
        }

        for(int i = 0; i < n; i++){
            if(inDeg[i] == 1) q.offer(i);
        }

        List<Integer> ans = new ArrayList<>();
        if(edges.length == 0){
            ans.add(0);
            return ans;
        }
        while(!q.isEmpty()){
            ans = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i < size; i++){
                int vertex = q.poll();
                ans.add(vertex);
                for(int neig : adj.get(vertex)){
                    inDeg[neig]--;
                    if(inDeg[neig] == 1) q.offer(neig);
                }
            }
        }

        return ans;
    }
}