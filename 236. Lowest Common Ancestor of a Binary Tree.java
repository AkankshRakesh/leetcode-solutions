/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean flag = false;

    public boolean build(TreeNode root, ArrayList<TreeNode> path, TreeNode target) {
        if (root == null)
            return false;

        path.add(root);
        if (root == target)
            return true;

        if (build(root.left, path, target) || build(root.right, path, target)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();
        build(root, path1, p);
        flag = false;
        build(root, path2, q);

        int n = path1.size();
        int m = path2.size();
        boolean check = true;
        int i = 0;
        while (i < path1.size() && i < path2.size() && path1.get(i) == path2.get(i)) {
            i++;
        }
        return path1.get(i - 1);
    }
}