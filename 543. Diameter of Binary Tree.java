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
    public int getAns(TreeNode node){
        if(node == null) return 0;
        int left = getAns(node.left);
        int right = getAns(node.right);
        
        ans = Math.max(ans, left + right);
        // System.out.println(left + " " + right + " : " + node.val);
        return 1 + Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        getAns(root);
        return ans;    
    }
}