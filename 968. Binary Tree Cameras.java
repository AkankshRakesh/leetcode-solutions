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
    // {camera, no camera - covered, no camera - not covered}
    private int[] solve(TreeNode node){
        if(node == null) return new int[]{10000, 0, 0};

        int[] left = solve(node.left);
        int[] right = solve(node.right);

        int camera = 1 + Math.min(left[0], Math.min(left[1], left[2])) + Math.min(right[0], Math.min(right[1], right[2]));

        int covered = Math.min(left[0] + Math.min(right[0], right[1]), right[0] + Math.min(left[0], left[1]));

        int notCovered = left[1] + right[1];

        return new int[]{camera, covered, notCovered};
    }
    public int minCameraCover(TreeNode root) {
        int[] result = solve(root);
        return Math.min(result[0], result[1]);
    }
}