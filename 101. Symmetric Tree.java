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
    public boolean trav(TreeNode node, TreeNode nodeInv){
        if(node == null && nodeInv == null) return true;
        else if((node == null && nodeInv != null) || (node != null && nodeInv == null)) return false;

        if(node.val != nodeInv.val) return false;

        return trav(node.left, nodeInv.right) && trav(node.right, nodeInv.left);
    }
    public boolean isSymmetric(TreeNode root) {
        TreeNode node = root;
        TreeNode nodeInv = root;
        return trav(node, nodeInv);
    }
}