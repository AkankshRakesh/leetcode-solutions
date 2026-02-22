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
    public int pickOrNot(TreeNode node, HashMap<TreeNode, Integer> hm){
        if(node == null) return 0;
        if(hm.containsKey(node)) return hm.get(node);

        int nodeleftleft = 0, nodeleftright = 0, noderightleft = 0, noderightright = 0;
        if(node.left != null){
            nodeleftleft = pickOrNot(node.left.left, hm);
            nodeleftright = pickOrNot(node.left.right, hm);
        }
        if(node.right != null){
            noderightleft = pickOrNot(node.right.left, hm);
            noderightright = pickOrNot(node.right.right, hm);
        }

        int val = Math.max(node.val + nodeleftleft + nodeleftright + noderightleft + noderightright, pickOrNot(node.left, hm) + pickOrNot(node.right, hm));
        hm.put(node, val);
        return val;
    }
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> hm = new HashMap<>();
        return pickOrNot(root, hm);
    }
}