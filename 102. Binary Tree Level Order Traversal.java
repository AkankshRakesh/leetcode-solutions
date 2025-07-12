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
    public void levelTrav(List<List<Integer>> arr, Queue<TreeNode> q){
        if(q.isEmpty()) return;
        ArrayList<Integer> curr = new ArrayList<Integer>();
        int n = q.size();
        while(n != 0){
            TreeNode ele = q.poll();
            curr.add(ele.val);
            if(ele.left != null) q.add(ele.left);
            if(ele.right != null) q.add(ele.right);
            n--;
        }
        arr.add(curr);
        levelTrav(arr, q);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        if(root == null) return arr;
        levelTrav( arr, q);

        return arr;
    }
}