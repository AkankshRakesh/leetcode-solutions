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
    public void build(TreeNode root, ArrayList<Integer> arr){
        if(root.left == null && root.right == null){
            // System.out.println(root.val);
            arr.add(root.val);
        }

        if(root.left != null) build(root.left, arr);
        if(root.right != null) build(root.right, arr);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        build(root1, arr1);
        build(root2, arr2);

        int n = arr1.size();
        if(n != arr2.size()) return false;

        for(int i = 0; i < n; i++){
            if(arr1.get(i) - arr2.get(i) != 0){
                // System.out.println(arr1.get(i));
                return false;
            }
        }

        return true;
    }
}