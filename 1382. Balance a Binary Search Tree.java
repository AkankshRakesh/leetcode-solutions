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
    public void inOrderTrav(TreeNode root, ArrayList<Integer> arr){
        if(root == null) return;
        
        inOrderTrav(root.left, arr);
        arr.add(root.val);
        inOrderTrav(root.right, arr);
    }
    public TreeNode buildTree(ArrayList<Integer> arr, int left, int right){
        if(left >= right) return null;
        int mid = left + (right - left) / 2;

        TreeNode node = new TreeNode(arr.get(mid));
        node.left = buildTree(arr, left, mid);
        node.right = buildTree(arr, mid + 1, right);

        return node;
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        inOrderTrav(root, arr);

        return buildTree(arr, 0, arr.size());
    }
}