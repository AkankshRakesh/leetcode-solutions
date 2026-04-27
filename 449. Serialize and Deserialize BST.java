/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public void preorder(TreeNode node, StringBuilder sb){
        if(node == null) return;
        
        sb.append(node.val + "#");
        preorder(node.left, sb);
        preorder(node.right, sb);
    }
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("");
        preorder(root, sb);
        // System.out.println(sb);
        
        return sb.toString();
    }
    
    int index = 0;
    public TreeNode buildTree(int[] preorder, int left, int right){
        if(index >= preorder.length) return null;
        if(preorder[index] < left || preorder[index] > right){
            index--;
            return null;
        }

        TreeNode node = new TreeNode(preorder[index]);
        int val = preorder[index];

        index++;
        node.left = buildTree(preorder, left, val);

        index++;
        node.right = buildTree(preorder, val, right);

        return node;
    }
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] strArr = data.split("#");
        int[] preorder = new int[strArr.length];
        for(int i = 0; i < preorder.length; i++){
            preorder[i] = Integer.parseInt(strArr[i]);
            // System.out.println(preorder[i]);
        }

        return buildTree(preorder, -1, Integer.MAX_VALUE);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;