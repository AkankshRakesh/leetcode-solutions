class Solution {
    public int minCost(int n, int[][] edges, int k) {
        int left = 0, right = 0;
        for(int[] ele : edges){
            right = right > ele[2] ? right : ele[2];
        }

        while(left < right){
            int mid = (left + right) / 2;
            if(canSplit(n, edges, k, mid)){
                right = mid;
            }
            else left = mid + 1;
        }

        return left;
    }
    public boolean canSplit(int n, int[][] edges, int k, int weight){
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] ele: edges){
            if(ele[2] <= weight){
                graph.get(ele[0]).add(ele[1]);
                graph.get(ele[1]).add(ele[0]);
            }
        }

        boolean[] visited = new boolean[n];
        int comps = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                comps++;
                dfs(i, graph, visited);
            }
        }

        return comps <= k;
    }

    public void dfs(int ele, List<List<Integer>> graph, boolean[] visited){
        Stack<Integer> stack = new Stack<>();
        stack.push(ele);
        visited[ele] = true;

        while(!stack.isEmpty()){
            int topEle = stack.pop();
            for(int nb : graph.get(topEle)){
                if(!visited[nb]){
                    visited[nb] = true;
                    stack.push(nb);
                }
            }
        }
    }
}