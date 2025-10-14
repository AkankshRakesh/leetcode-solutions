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
    int ans = 0;
    public int trav(TreeNode node){
        if(node == null) return 0;
        
        int left = trav(node.left);
        int right = trav(node.right);

        ans = Math.max(ans, left + right);
        return Math.max(left, right) + 1;
    } 
    public int diameterOfBinaryTree(TreeNode root) {
        trav(root);
        return ans;
    }
}