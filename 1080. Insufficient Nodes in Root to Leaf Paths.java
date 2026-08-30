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
    public TreeNode dfs(TreeNode node, int limit, int sum){
        if(node == null){
            // System.out.println(sum);
            if(sum < limit) return new TreeNode(Integer.MIN_VALUE);
            return null;
        }

        TreeNode left = dfs(node.left, limit, sum + node.val);
        TreeNode right = dfs(node.right, limit, sum + node.val);
        
        if(left == null && right == null) return node;
        else if(left != null && right != null){
            if(left.val == Integer.MIN_VALUE && right.val == Integer.MIN_VALUE) return left;
            else if(left.val == Integer.MIN_VALUE){
                node.left = null;
                node.right = right;
            }
            else if(right.val == Integer.MIN_VALUE){
                node.left = left;
                node.right = null;
            }
            else{
                node.left = left;
                node.right = right;
            }
        }
        else if(left != null){
            if(left.val == Integer.MIN_VALUE) return left;
            else node.left = left;
            node.right = right;
        }
        else if(right != null){
            if(right.val == Integer.MIN_VALUE) return right;
            else node.right = right;
            node.left = left;
        }

        return node;
    }
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        root = dfs(root, limit, 0);
        if(root.val == Integer.MIN_VALUE) return null;
        return root;
    }
}