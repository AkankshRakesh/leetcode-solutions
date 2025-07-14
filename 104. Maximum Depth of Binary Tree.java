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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int levels = 0;
        while(!q.isEmpty()){
            int n = q.size();
            while(n != 0){
                TreeNode ele = q.poll();
                if(ele.left != null) q.offer(ele.left);
                if(ele.right != null) q.offer(ele.right);
                n--;
            }
            levels++;
        }

        return levels;
    }
}