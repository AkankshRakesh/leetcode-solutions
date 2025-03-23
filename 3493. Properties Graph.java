class Solution {
    public static int intersect(int[] a, int[] b) {
        Set<Integer> setA = new HashSet<>();
        for (int num : a) {
            setA.add(num);
        }
        Set<Integer> setB = new HashSet<>();
        for (int num : b) {
            setB.add(num);
        }
        setA.retainAll(setB);
        return setA.size();
    }

    public static void dfs(int node, Map<Integer, List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }
    public int numberOfComponents(int[][] properties, int k) {
         int n = properties.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (intersect(properties[i], properties[j]) >= k) {
                    graph.computeIfAbsent(i, x -> new ArrayList<>()).add(j);
                    graph.computeIfAbsent(j, x -> new ArrayList<>()).add(i);
                }
            }
        }

        boolean[] visited = new boolean[n];
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited);
                components++;
            }
        }
        return components;
    }
}