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
    public TreeNode findNode(TreeNode node, int key){
        if(node == null) return null;

        TreeNode left = findNode(node.left, key);
        TreeNode right = findNode(node.right, key);
        if(node.val == key){
            if(node.left == null && node.right == null) return null;
            else if(node.left == null){
                return node.right;
            }
            else if(node.right == null){
                return node.left;
            }
            else{
                TreeNode next = node.right;
                while(next.left != null) next = next.left;
                node.val = next.val;
                node.right = findNode(node.right, next.val);
                node.left = left;
            }
        }
        else{
            node.left = left;
            node.right = right;
        }

        return node;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        return findNode(root, key);
    }
}