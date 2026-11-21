
class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<Integer>[] tree = new ArrayList[n];
        List<Integer>[] newTree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
            newTree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        int[] last = new int[26];
        Arrays.fill(last, -1);

        buildTree(0, tree, newTree, s, last, parent);

        int[] ans = new int[n];
        dfs(0, newTree, ans);

        return ans;
    }

    private void buildTree(int node, List<Integer>[] tree, List<Integer>[] newTree, String s, int[] last, int[] parent) {

        int ch = s.charAt(node) - 'a';
        int prev = last[ch];

        int newParent = (prev == -1) ? parent[node] : prev;

        if (node != 0) {
            newTree[newParent].add(node);
        }

        last[ch] = node;

        for (int child : tree[node]) {
            buildTree(child, tree, newTree, s, last, parent);
        }

        last[ch] = prev;
    }

    private int dfs(int node, List<Integer>[] tree, int[] ans) {
        int size = 1;

        for (int child : tree[node]) {
            size += dfs(child, tree, ans);
        }

        ans[node] = size;
        return size;
    }
}
