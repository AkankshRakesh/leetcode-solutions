class Solution {

    private int dfs(int currentNode, int parentNode,
                    List<Integer>[] adjList, int[] values,
                    int k, int[] componentCount) {

        int sum = 0;

        for (int neighbor : adjList[currentNode]) {
            if (neighbor != parentNode) {
                sum += dfs(neighbor, currentNode, adjList, values, k, componentCount);
                sum %= k;
            }
        }

        sum += values[currentNode];
        sum %= k;

        if (sum == 0) {
            componentCount[0]++;
        }

        return sum;
    }

    public int maxKDivisibleComponents(int n, int[][] edges,
                                       int[] values, int k) {

        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }

        int[] componentCount = new int[1];

        dfs(0, -1, adjList, values, k, componentCount);

        return componentCount[0];
    }
}
