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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        ArrayList<Integer> currArr = new ArrayList<>();
        List<List<Integer>> arr = new ArrayList<>();
        if(root == null) return arr;
        boolean reverse = false;

        while(!q.isEmpty()){
            int size = q.size();
            while(size != 0){
                TreeNode ele = q.poll();
                currArr.add(ele.val);
                if(ele.left != null) q.add(ele.left);
                if(ele.right != null) q.add(ele.right);
                size--;
            }

            if(reverse){
                Collections.reverse(currArr);
            }
            reverse = !reverse;
            arr.add(new ArrayList<Integer>(currArr));
            currArr = new ArrayList<>();
        }

        return arr;

    }
}