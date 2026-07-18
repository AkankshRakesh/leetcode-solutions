class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        Boolean[] color = new Boolean[graph.length];

        for(int i = 0; i < color.length; i++){
            if(color[i] == null){
                q.offer(i);
                color[i] = true;
                while(!q.isEmpty()){
                    int node = q.poll();
                    boolean nodeColor = color[node];

                    for(int neig : graph[node]){
                        if(color[neig] != null && color[neig] == nodeColor) return false;
                        if(color[neig] == null) q.offer(neig);
                        color[neig] = !nodeColor;
                    }
                }
            }
        }

        return true;
    }
}