class Solution {
    public void dfs(int curr,List<Integer>[] graph, boolean[] visited, int[] info){
        visited[curr] = true;
        info[0]++;
        info[1] += graph[curr].size();

        for(int next: graph[curr]){
            if(!visited[next]){
                dfs(next, graph, visited, info);
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int count = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;

            int[] info = new int[2];
            dfs(i, graph, visited, info);

            if(info[0] * (info[0] - 1) == info[1]){
                count++;
                System.out.println(i);
            }
        }
        return count;
    }
}