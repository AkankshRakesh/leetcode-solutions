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
    public int bfs(TreeNode node, int[] sum){
        if(node == null) return 0;

        int left = Math.max(0, bfs(node.left, sum));
        int right = Math.max(0, bfs(node.right, sum));
        
        sum[0] = Math.max(sum[0], left + right + node.val);

        return Math.max(left, right) + node.val;
    }
    public int maxPathSum(TreeNode root) {
        int[] sum = { root.val };
        bfs(root, sum);
        return sum[0];
    }
}