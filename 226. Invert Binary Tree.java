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
    public TreeNode switcheroo(TreeNode node){
        if(node == null) return node;
        TreeNode temp = switcheroo(node.left);
        node.left = switcheroo(node.right);
        node.right = temp;
        return node;
    }
    public TreeNode invertTree(TreeNode root) {
        return switcheroo(root);
    }
}