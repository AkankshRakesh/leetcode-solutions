class Solution {
    public void dfs(HashMap<Integer, ArrayList<Integer>> adj, List<List<Integer>> ans, ArrayList<Integer> currArr,
            int ele, int target) {
        currArr.add(ele);
        
        if (ele == target) {
            ans.add(new ArrayList<>(currArr));
        } else {
            ArrayList<Integer> neighbors = adj.get(ele);
            if (neighbors != null) {
                for (int nb : neighbors) {
                    dfs(adj, ans, currArr, nb, target);
                }
            }
        }

        currArr.remove(currArr.size() - 1);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        int n = graph.length;

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            int m = graph[i].length;
            for (int j = 0; j < m; j++) {
                arr.add(graph[i][j]);
            }
            adj.put(i, arr);
        }

        List<List<Integer>> arr = new ArrayList<>();
        dfs(adj, arr, new ArrayList<>(), 0, n - 1);

        return arr;
    }
}