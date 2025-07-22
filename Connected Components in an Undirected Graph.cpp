
class Solution {
    public void dfs(HashMap<Integer, ArrayList<Integer>> adj,int ele, boolean[] visited, ArrayList<Integer> temp){
        visited[ele] = true;
        temp.add(ele);
        
        for(int nb : adj.get(ele)){
            if(!visited[nb]){
                dfs(adj, nb, visited, temp);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            adj.put(i, new ArrayList<>()); 
        }
        int e = edges.length;
        for(int i = 0; i < e; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(adj.containsKey(u)){
                adj.get(u).add(v);
            }
            else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(v);
                adj.put(u, temp);
            }
            if(adj.containsKey(v)){
                adj.get(v).add(u);
            }
            else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(u);
                adj.put(v, temp);
            }
        }
        
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                ArrayList<Integer> temp = new ArrayList<>();
                dfs(adj,i, visited, temp);
                arr.add(temp);
            }
        }
        
        return arr;
    }
}