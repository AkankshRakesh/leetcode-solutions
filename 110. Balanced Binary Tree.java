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
    boolean res = true;
    public int dfs(TreeNode node){
        if(node == null) return 0;
        
        int leftTree = dfs(node.left);
        int rightTree = dfs(node.right);

        if(Math.abs(leftTree - rightTree) > 1) res = false;
        
        return 1 + Math.max(leftTree, rightTree);
    }
    public boolean isBalanced(TreeNode root) {
        dfs(root);

        return res;
    }
}