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
    public TreeNode build(Queue<Integer> preOrder, int[] inorder, HashMap<Integer, Integer> hm, int lastInd){
        if(preOrder.isEmpty()) return null;
        int val = preOrder.peek();
        int index = hm.get(val);

        if(index > lastInd) return null;
        preOrder.poll();
        TreeNode curr = new TreeNode(val);
        curr.left = build(preOrder, inorder, hm, index);
        curr.right = build(preOrder, inorder, hm, lastInd);

        return curr;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            hm.put(inorder[i], i);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int node : preorder) q.offer(node);

        return build(q, inorder, hm, inorder.length - 1); 
    }
}