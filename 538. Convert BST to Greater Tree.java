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
    int sum = 0;
    public void solve(TreeNode node){
        if(node == null) return;

        solve(node.right);
        int prev = node.val;
        node.val += sum;
        sum += prev;
        solve(node.left);
    }
    public TreeNode convertBST(TreeNode root) {
        solve(root);
        return root;
    }
}