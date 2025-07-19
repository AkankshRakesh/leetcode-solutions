/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public void buildPath(TreeNode root, TreeNode target, ArrayList<TreeNode> arr){
        while(root.val != target.val){
            arr.add(root);
            if(root.val > target.val){
                root = root.left;
            }
            else root = root.right;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> arr1 = new ArrayList<>();
        ArrayList<TreeNode> arr2 = new ArrayList<>();

        buildPath(root, p, arr1);
        buildPath(root, q, arr2);
        arr1.add(p);
        arr2.add(q);

        int n = arr1.size(), m = arr2.size();
        for(int i = 1; i < n && i < m; i++){
            if(arr1.get(i).val != arr2.get(i).val) return arr1.get(i - 1);
        }

        if(n > m){
            return arr2.get(m - 1);
        }
        return arr1.get(n - 1);
    }
}