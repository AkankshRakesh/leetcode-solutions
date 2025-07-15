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
    public void trav(TreeNode node, ArrayList<String> arr, String curr){
        if(node == null){
            return;
        }

        if(node.left == null && node.right == null){
            arr.add(curr + node.val);
            return;
        }

        curr += String.format("%d", node.val) + "->";
        if(node.left != null) trav(node.left, arr, curr);
        if(node.right != null) trav(node.right, arr, curr);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> arr = new ArrayList<>();
        trav(root, arr, "");
        return arr;
    }
}