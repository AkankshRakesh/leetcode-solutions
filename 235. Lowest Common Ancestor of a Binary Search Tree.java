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
    // public TreeNode dfs(TreeNode node, TreeNode p, TreeNode q){
    //     if(node == null) return null;
    //     if((node.val > p.val && node.val < q.val) || (node.val < p.val && node.val > q.val) || (node.val == p.val) || (node.val == q.val)) return node;

    //     if(node.val > p.val) return dfs(node.left, p, q);
    //     return dfs(node.right, p, q);
    // }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if((node.val > p.val && node.val < q.val) || (node.val < p.val && node.val > q.val) || (node.val == p.val) || (node.val == q.val)) return node;

            if(node.val > p.val) queue.offer(node.left);
            else queue.offer(node.right);
        }

        return root;
    }
}