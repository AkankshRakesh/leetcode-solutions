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
    public TreeNode getPrev(TreeNode node){
        while(node.right != null) node = node.right;

        return node;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val < key) root.right = deleteNode(root.right, key);
        else if(root.val > key) root.left = deleteNode(root.left, key);
        else{
            if(root.left == null && root.right == null) return null;
            else if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else{
                TreeNode prev = getPrev(root.left);
                root.val = prev.val;

                root.left = deleteNode(root.left, prev.val);
            }
        }

        return root;
    }
}