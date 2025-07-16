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
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        ArrayList<Integer> arr = new ArrayList<>();
        if(root == null) return arr;
        
        int size = 1;
        while(!q.isEmpty()){
            TreeNode top = q.poll();
            
            if(top.left != null) q.offer(top.left);
            if(top.right != null) q.offer(top.right);

            size--;
            if(size == 0){
                size = q.size();
                arr.add(top.val);
            }
        }
        
        return arr;
    }
}