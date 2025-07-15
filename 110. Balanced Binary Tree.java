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
    boolean ans = true;
    public int trav(TreeNode node){
        if(node == null) return 0;

        int left = trav(node.left);
        int right = trav(node.right);

        if(Math.abs(left - right) > 1){
            ans = false;
        }
        return 1 + Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        trav(root);
        return ans;
    }
}