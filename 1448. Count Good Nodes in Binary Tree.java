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
    public void largestTillNode(TreeNode node, int max, int[] ans){
        if(node == null) return;
        if(node.val >= max){
            ans[0]++;
            largestTillNode(node.left, node.val, ans);
            largestTillNode(node.right, node.val, ans);
        }
        else{
            largestTillNode(node.left, max, ans);
            largestTillNode(node.right, max, ans);
        }
    }
    public int goodNodes(TreeNode root) {
        int[] ans = new int[1];
        largestTillNode(root, root.val, ans);

        return ans[0];
    }
}