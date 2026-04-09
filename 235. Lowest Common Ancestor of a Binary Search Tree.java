/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans = new TreeNode(-1);
    public void dfs(TreeNode node, TreeNode p, TreeNode q){
        if(node == null) return;
        // System.out.println(node.val);
        if((p.val > node.val && q.val < node.val) || (p.val < node.val && q.val > node.val) || (p.val == node.val) || (q.val == node.val)){
            ans = node;
            return;
        }
        if(p.val < node.val) dfs(node.left, p, q);
        else dfs(node.right, p, q);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }
}