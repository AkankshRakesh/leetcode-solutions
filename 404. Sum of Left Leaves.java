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
    public int traverse(TreeNode node, boolean isLeft){
        if(node == null) return 0;
        if(node.left == null && node.right == null){
            if(isLeft) return node.val;
            return 0;
        }

        int ans = traverse(node.left, true) + traverse(node.right, false);
        return ans;
    }
    public int sumOfLeftLeaves(TreeNode root) {
        return traverse(root, false);
    }
}