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
    int ans = Integer.MIN_VALUE;
    public int find(TreeNode root){
        if(root == null) return 0;
        int left = find(root.left);
        int right = find(root.right);

        ans = Math.max(ans, 1 + left + right);
        return 1 + Math.max(left, right);
    } 
    public int diameterOfBinaryTree(TreeNode root) {
        find(root);
        return ans - 1;
    }
}