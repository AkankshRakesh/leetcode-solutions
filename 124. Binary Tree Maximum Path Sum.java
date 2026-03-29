/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = -1001;
    public int dfs(TreeNode root){
        if(root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        // root + left + right as ans 
        ans = Math.max(ans, Math.max(left + root.val + right, Math.max(left + root.val, Math.max(right + root.val, root.val))));

        // root + left || root + right || root and send up the tree
        return Math.max(root.val + left, Math.max(root.val + right, root.val));
    }
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans; 
    }
}