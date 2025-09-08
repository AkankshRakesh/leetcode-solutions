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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int size = 1;
        while(!q.isEmpty()){
            size--;
            TreeNode top = q.poll();
            if(top.left != null) q.offer(top.left);
            if(top.right != null) q.offer(top.right);

            if(size == 0){
                ans.add(top.val);
                size = q.size();
            }
        }

        return ans;
    }
}