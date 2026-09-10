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
    public int[] traverse(TreeNode node){
        if(node == null) return new int[]{0, 0};

        int[] left = traverse(node.left);
        int[] right = traverse(node.right);

        int n = left[0] + right[0] + 1;
        int sum = left[1] + right[1] + node.val;

        if((sum / n) == node.val) ans++;

        return new int[]{n, sum};
    }
    public int averageOfSubtree(TreeNode root) {
        traverse(root);
        return ans;
    }
}