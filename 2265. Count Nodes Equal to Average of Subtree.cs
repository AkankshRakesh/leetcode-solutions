/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
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
    public int AverageOfSubtree(TreeNode root) {
        traverse(root);
        return ans;
    }
}