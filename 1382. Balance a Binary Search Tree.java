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
    public void inOrder(TreeNode root, ArrayList<Integer> arr){
        if(root == null) return;

        inOrder(root.left, arr);
        arr.add(root.val);
        inOrder(root.right,arr);
    }
    public TreeNode buildTree(ArrayList<Integer> arr, int left, int right, int n){
        if(left > right) return null;

        int mid = left + (right - left)/2;
        TreeNode node = new TreeNode(arr.get(mid));

        node.left = buildTree(arr,left, mid - 1, n);
        node.right = buildTree(arr,mid + 1, right, n);

        return node;
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        inOrder(root, arr);
        int n = arr.size();

        return buildTree(arr, 0, n - 1, n);
    }
}