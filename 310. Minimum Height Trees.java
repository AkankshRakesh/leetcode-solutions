class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if(n == 1){
            ans.add(0);
            return ans;
        }
        if(n == 2){
            ans.add(0);
            ans.add(1);
            return ans;
        }

        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();

        int inDeg[] = new int[n];
        for(int[] edge : edges){
            ArrayList<Integer> temp = adj.getOrDefault(edge[0], new ArrayList<>());
            ArrayList<Integer> temp2 = adj.getOrDefault(edge[1], new ArrayList<>());
            temp.add(edge[1]);
            temp2.add(edge[0]);
            inDeg[edge[0]]++;
            inDeg[edge[1]]++;
            adj.put(edge[0], temp);
            adj.put(edge[1], temp2);
        }

        int nodesRemoved = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(inDeg[i] == 1){
                q.offer(i);
                nodesRemoved++;
                inDeg[i] = 0;
            }
        }
        while(!q.isEmpty()){
            if(n - nodesRemoved <= 2) break;
            int size = q.size();
            for(int i = 0; i < size; i++){
                int node = q.poll();
                for(int neig : adj.get(node)){
                    inDeg[neig]--;
                    if(inDeg[neig] == 1){
                        nodesRemoved++;
                        q.offer(neig);
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(inDeg[i] > 1) ans.add(i);
        }

        return ans;
    }
}