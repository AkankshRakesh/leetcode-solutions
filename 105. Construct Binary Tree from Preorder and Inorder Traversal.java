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
    int index = 0;
    public TreeNode build(int[] preorder, HashMap<Integer, Integer> hm, int left, int right){
        if(left > right) return null;
        TreeNode node = new TreeNode(preorder[index]);
        index++;

        int rootIndex = hm.get(node.val);
        node.left = build(preorder, hm, left, rootIndex - 1);
        node.right = build(preorder, hm, rootIndex + 1, right);

        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            hm.put(inorder[i], i);
        }
        TreeNode root = build(preorder, hm, 0, inorder.length - 1);
        return root;
    }
}