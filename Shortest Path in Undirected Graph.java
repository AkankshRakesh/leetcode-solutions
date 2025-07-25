
class Solution {
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        int n = adj.size();
        for(int i = 0; i < n; i++){
            ArrayList<Integer> arr = new ArrayList<>();
            for(int j = 0; j < adj.get(i).size(); j++){
                arr.add(adj.get(i).get(j));
            }
            hm.put(i, arr);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        int[] res = new int[n];
        for(int i = 0; i < n; i++) res[i] = -1;
        res[src] = 0;
        
        while(!q.isEmpty()){
            int top = q.poll();
            if(hm.get(top).size() != 0){
                for(int nb: hm.get(top)){
                    if(res[nb] == -1){
                        q.offer(nb);
                        res[nb] = res[top] + 1;
                    }
                }
            }
        }
        
        return res;
    }
}
