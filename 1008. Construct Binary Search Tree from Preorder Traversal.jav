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
    int index = -1;
    public TreeNode buildTree(int[] preorder, HashMap<Integer, Integer> hm, int l, int r){
        if(l > r) return null;

        index++;
        int mid = hm.get(preorder[index]);
        TreeNode node = new TreeNode(preorder[index]);

        node.left = buildTree(preorder, hm, l, mid - 1);

        node.right = buildTree(preorder, hm, mid + 1, r);

        return node;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder = new int[preorder.length];
        for(int i = 0; i < preorder.length; i++) inorder[i] = preorder[i];
        Arrays.sort(inorder);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            hm.put(inorder[i], i);
        }
        
        return buildTree(preorder, hm, 0, preorder.length - 1);
    }
}