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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;
        int size = 1;
        while(!q.isEmpty()){
            TreeNode top = q.poll();
            if(top.left == null && top.right == null) return level;
            
            if(top.left != null) q.offer(top.left);
            if(top.right != null) q.offer(top.right);
            size--;
            if(size == 0){
                level++;
                size = q.size();
            }
        }

        return level;
    }
}